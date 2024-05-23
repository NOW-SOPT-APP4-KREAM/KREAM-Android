package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendAdvertisementBinding

class RecommendAdvertisementViewHolder(
    private val binding: ItemRecommendAdvertisementBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: Int) {
        with(binding) {
            ivRecommendAdvertisement.setImageResource(item)
        }
    }
}
