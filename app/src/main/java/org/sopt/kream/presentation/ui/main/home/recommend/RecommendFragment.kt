package org.sopt.kream.presentation.ui.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentRecommendBinding
import org.sopt.kream.util.base.BindingFragment

class RecommendFragment : BindingFragment<FragmentRecommendBinding>({ FragmentRecommendBinding.inflate(it) }) {
    private val recommendViewModel by viewModels<RecommendViewModel>()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        initRecommendAds()
        initCircleMenu()
        initForYouProduct()
        initJustDropped()
        initStyle()
    }

    private fun initRecommendAds() {
        binding.vpRecommendAd.adapter = RecommendAdViewPagerAdapter(recommendViewModel.getAdImage())
        TabLayoutMediator(binding.tabKreamIndicator.tabKreamIndicator, binding.vpRecommendAd) { tab, position ->
        }.attach()
    }

    private fun initCircleMenu() {
        binding.rvRecommendCircleMenu.apply {
            layoutManager = GridLayoutManager(context, 5)
            adapter = RecommendCircleMenuAdapter(recommendViewModel.getCircleMenu())
        }
    }

    private fun initForYouProduct() {
        binding.vpRecommendForYouContent.adapter = RecommendForYouViewPagerAdapter(recommendViewModel.getForYouList())
    }

    private fun initJustDropped() {
        val recommendJustDroppedAdapter = RecommendJustDroppedAdapter(::navigateToProductDetail)
        binding.rvRecommendReleaseContent.adapter = recommendJustDroppedAdapter
        recommendJustDroppedAdapter.submitList(recommendViewModel.getJustDropped())
    }

    private fun initStyle() {
        val recommendStyleAdapter = RecommendStyleAdapter()
        binding.rvRecommendInstagram.adapter = recommendStyleAdapter
        recommendStyleAdapter.submitList(recommendViewModel.getInstagram())
    }

    private fun navigateToProductDetail(productId: Int) {
        findNavController().navigate(R.id.action_search_to_product_detail, bundleOf(PRODUCT_ID to productId))
    }

    companion object {
        const val PRODUCT_ID = "productId"
    }
}
