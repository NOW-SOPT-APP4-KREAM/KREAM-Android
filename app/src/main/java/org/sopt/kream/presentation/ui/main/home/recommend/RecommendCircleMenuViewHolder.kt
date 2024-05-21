package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendCircleMenuBinding

class RecommendCircleMenuViewHolder(
    private val binding: ItemRecommendCircleMenuBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        item: String,
    ) {
        with(binding) {
            tvCircleMenuTitle.text = item
        }
    }
}
