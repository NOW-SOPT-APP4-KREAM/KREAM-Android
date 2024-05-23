package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendStyleBinding
import org.sopt.kream.domain.model.InstagramModel

class RecommendStyleViewHolder(
    private val binding: ItemRecommendStyleBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        recommendInstagram: InstagramModel,
        position: Int,
    ) {
        with(binding) {
            ivStyle.setImageResource(recommendInstagram.image)
            tvStyleId.text = recommendInstagram.id
        }
    }
}
