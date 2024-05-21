package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendInstagramBinding

class RecommendStyleViewHolder(
    private val binding: ItemRecommendInstagramBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        recommendInstagram: RecommendViewModel.Instagram,
        position: Int,
    ) {
        with(binding) {
            ivInstagram.setImageResource(recommendInstagram.image)
            tvInstagramId.text = recommendInstagram.id
        }
    }
}
