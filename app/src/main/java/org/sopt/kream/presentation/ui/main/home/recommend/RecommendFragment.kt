package org.sopt.kream.presentation.ui.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

        initBtnProductDetail()
        initRecommendAds()
    }

    private fun initBtnProductDetail() {
        binding.btnToProductDetail.setOnClickListener {
            findNavController().navigate(R.id.action_recommend_to_product_detail)
        }
    }

    private fun initRecommendAds() {
        binding.vpRecommendAd.adapter = RecommendViewPagerAdapter(recommendViewModel.getAdImage())
        TabLayoutMediator(binding.tabKreamIndicator.tabKreamIndicator, binding.vpRecommendAd) { tab, position ->
        }.attach()
    }
}
