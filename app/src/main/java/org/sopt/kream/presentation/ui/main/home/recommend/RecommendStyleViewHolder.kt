package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendStyleBinding

class RecommendStyleViewHolder(
    private val binding: ItemRecommendStyleBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        recommendInstagram: RecommendViewModel.Instagram,
        position: Int,
    ) {
        with(binding) {
            ivStyle.setImageResource(recommendInstagram.image)
            tvStyleId.text = recommendInstagram.id
        }
    }
}
