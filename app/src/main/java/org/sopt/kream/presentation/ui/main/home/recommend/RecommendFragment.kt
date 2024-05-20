package org.sopt.kream.presentation.ui.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
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
    }

    private fun initRecommendAds() {
        binding.vpRecommendAd.adapter = RecommendAdViewPagerAdapter(recommendViewModel.getAdImage())
        TabLayoutMediator(binding.tabKreamIndicator.tabKreamIndicator, binding.vpRecommendAd) { tab, position ->
        }.attach()
    }
}
