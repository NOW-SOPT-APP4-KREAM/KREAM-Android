package org.sopt.kream.presentation.ui.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentRecommendBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.presentation.ui.type.RecommendAdvertisementType
import org.sopt.kream.presentation.ui.type.RecommendCircleMenuType
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.view.UiState

class RecommendFragment : BindingFragment<FragmentRecommendBinding>({ FragmentRecommendBinding.inflate(it) }) {
    private val recommendViewModel: RecommendViewModel by viewModels { ViewModelFactory() }
    private var memberId: Int = 1
    private lateinit var advertisementAdapter: RecommendAdViewPagerAdapter
    private lateinit var circleMenuAdapter: RecommendCircleMenuAdapter
    private lateinit var forYouAdapter: RecommendForYouViewPagerAdapter
    private lateinit var justDroppedAdapter: RecommendJustDroppedAdapter
    private lateinit var styleAdapter: RecommendStyleAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        recommendViewModel.getRecommendProduct(memberId = memberId)
        initAdapter()
        setBottomSheet()
        collectRecommendProductState()
    }

    private fun initAdapter() {
        advertisementAdapter = RecommendAdViewPagerAdapter(RecommendAdvertisementType.RECOMMEND_ADVERTISEMENT.advertisementList)
        circleMenuAdapter = RecommendCircleMenuAdapter(RecommendCircleMenuType.entries)
        forYouAdapter = RecommendForYouViewPagerAdapter(::navigateToProductDetail, ::navigateToSearch)
        justDroppedAdapter = RecommendJustDroppedAdapter(::navigateToProductDetail)
        styleAdapter = RecommendStyleAdapter()

        with(binding) {
            vpRecommendAdvertisement.adapter = advertisementAdapter
            TabLayoutMediator(tabKreamIndicator.tabKreamIndicator, vpRecommendAdvertisement) { tab, position ->
            }.attach()
            rvRecommendCircleMenu.adapter = circleMenuAdapter
            vpRecommendForYouContent.adapter = forYouAdapter
            rvRecommendJustDroppedContent.adapter = justDroppedAdapter
            rvRecommendStyle.adapter = styleAdapter
        }
    }

    private fun collectRecommendProductState() {
        recommendViewModel.recommendProductState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { recommendProductState ->
                when (recommendProductState) {
                    is UiState.Success -> {
                        with(recommendProductState.data) {
                            forYouAdapter.submitList(listOf(recommendForYouProducts))
                            justDroppedAdapter.submitList(recommendJustDroppedProducts)
                            styleAdapter.submitList(recommendViewModel.instagramList)
                        }
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun navigateToProductDetail(productId: Int) {
        findNavController().navigate(R.id.action_recommend_to_product_detail, bundleOf(PRODUCT_ID to productId))
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

    companion object {
        const val PRODUCT_ID = "productId"
        const val SEARCH_WORD = "searchWord"
    }
}
