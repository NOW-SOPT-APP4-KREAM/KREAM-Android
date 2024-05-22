package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendAdBinding

class RecommendAdvertisementViewHolder(
    private val binding: ItemRecommendAdBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        item: Int,
    ) {
        with(binding) {
            ivRecommendAd.setImageResource(item)
        }
    }
}
