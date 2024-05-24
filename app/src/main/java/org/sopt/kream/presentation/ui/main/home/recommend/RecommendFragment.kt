package org.sopt.kream.presentation.ui.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.size
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentRecommendBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.presentation.type.RecommendAdvertisementType
import org.sopt.kream.presentation.type.RecommendCircleMenuType
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.chunkList
import org.sopt.kream.util.view.UiState

class RecommendFragment : BindingFragment<FragmentRecommendBinding>({ FragmentRecommendBinding.inflate(it) }) {
    private val recommendViewModel: RecommendViewModel by viewModels { ViewModelFactory() }
    private lateinit var advertisementAdapter: RecommendAdvertisementViewPagerAdapter
    private lateinit var circleMenuAdapter: RecommendCircleMenuAdapter
    private lateinit var forYouAdapter: RecommendForYouViewPagerAdapter
    private lateinit var justDroppedAdapter: RecommendJustDroppedAdapter
    private lateinit var styleAdapter: RecommendStyleAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        recommendViewModel.getRecommendProduct()
        addListeners()
        initAdapter()
        setBottomSheet()
        collectRecommendProductState()
    }

    override fun onResume() {
        super.onResume()
        recommendViewModel.getRecommendProduct()
    }

    private fun addListeners() {
        with(binding) {
            ivRecommendForYouBack.setOnClickListener {
                if (vpRecommendForYouContent.currentItem != 0) vpRecommendForYouContent.currentItem--
            }

            ivRecommendForYouNext.setOnClickListener {
                if (vpRecommendForYouContent.currentItem != vpRecommendForYouContent.size) vpRecommendForYouContent.currentItem++
            }
        }
    }

    private fun initAdapter() {
        advertisementAdapter = RecommendAdvertisementViewPagerAdapter()
        circleMenuAdapter = RecommendCircleMenuAdapter()
        forYouAdapter = RecommendForYouViewPagerAdapter(::navigateToProductDetail, ::navigateToSearch)
        justDroppedAdapter = RecommendJustDroppedAdapter(::navigateToProductDetail, ::postScrapProduct, ::deleteScrapProduct)
        styleAdapter = RecommendStyleAdapter()

        with(binding) {
            vpRecommendAdvertisement.adapter = advertisementAdapter
            TabLayoutMediator(includeKreamIndicator.tabKreamIndicator, vpRecommendAdvertisement) { tab, position ->
            }.attach()
            rvRecommendCircleMenu.adapter = circleMenuAdapter
            vpRecommendForYouContent.adapter = forYouAdapter
            rvRecommendJustDroppedContent.adapter = justDroppedAdapter
            rvRecommendStyle.adapter = styleAdapter

            vpRecommendForYouContent.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        tvRecommendForYouCurrentPage.text = (position + 1).toString()
                    }
                },
            )
        }

        advertisementAdapter.submitList(RecommendAdvertisementType.RECOMMEND_ADVERTISEMENT.advertisementList)
        circleMenuAdapter.submitList(RecommendCircleMenuType.entries)
        styleAdapter.submitList(recommendViewModel.instagramList)
    }

    private fun collectRecommendProductState() {
        recommendViewModel.recommendProductState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { recommendProductState ->
                when (recommendProductState) {
                    is UiState.Success -> {
                        with(recommendProductState.data) {
                            chunkList(recommendForYouProducts, FOR_YOU_SIZE).let { recommendForYouProductList ->
                                forYouAdapter.submitList(recommendForYouProductList)
                                binding.tvRecommendForYouTotalPage.text = recommendForYouProductList.size.toString()
                            }
                            justDroppedAdapter.submitList(recommendJustDroppedProducts)
                        }
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun navigateToProductDetail(productId: Int) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(PRODUCT_ID to productId))
    }

    private fun navigateToSearch(searchKeyword: String) {
        findNavController().navigate(R.id.action_home_to_search, bundleOf(SEARCH_WORD to searchKeyword))
    }

    private fun setBottomSheet() {
        val forYouBottomSheet = BottomSheetDialog(requireContext())
        forYouBottomSheet.setContentView(
            layoutInflater.inflate(
                R.layout.fragment_recommend_for_you_bottom_sheet,
                null,
            ),
        )

        binding.ivRecommendForYouEtc.setOnClickListener {
            forYouBottomSheet.show()
        }
    }

    private fun postScrapProduct(productId: Int) {
        recommendViewModel.postScrapProduct(productId = productId)
    }

    private fun deleteScrapProduct(productId: Int) {
        recommendViewModel.deleteScrapProduct(productId = productId)
    }

    companion object {
        const val PRODUCT_ID = "productId"
        const val SEARCH_WORD = "searchWord"
        const val FOR_YOU_SIZE = 6
    }
}
