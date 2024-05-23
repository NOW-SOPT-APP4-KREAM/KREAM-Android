package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendCircleMenuBinding
import org.sopt.kream.presentation.ui.type.RecommendCircleMenuType

class RecommendCircleMenuViewHolder(
    private val binding: ItemRecommendCircleMenuBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        item: RecommendCircleMenuType,
    ) {
        with(binding) {
            ivCircleMenu.setImageResource(item.image)
            tvCircleMenuTitle.setText(item.menu)
        }
    }
}
