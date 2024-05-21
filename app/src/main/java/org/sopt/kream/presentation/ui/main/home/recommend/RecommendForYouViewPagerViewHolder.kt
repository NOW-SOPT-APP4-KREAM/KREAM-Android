package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.FragmentRecommendForYouBinding
import org.sopt.kream.domain.model.RecommendForYouProductModel

class RecommendForYouViewPagerViewHolder(
    private val binding: FragmentRecommendForYouBinding,
    private val navigateToProductDetail: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        item: List<RecommendForYouProductModel>,
        position: Int,
    ) {
        val recommendForYouAdapter = RecommendForYouAdapter(navigateToProductDetail, position)
        binding.rvForYouContent.adapter = recommendForYouAdapter
        recommendForYouAdapter.submitList(item)
    }
}
