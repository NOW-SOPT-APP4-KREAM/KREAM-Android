package org.sopt.kream.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.kream.databinding.ItemSearchRelateRecommendProductBinding
import org.sopt.kream.domain.model.RelateRecommendProductModel

class SearchRelateRecommendProductViewHolder(
    private val binding: ItemSearchRelateRecommendProductBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(relateRecommendProductModel: RelateRecommendProductModel) {
        with(binding) {
            ivSearchRelateRecommendProductThumbnail.load(relateRecommendProductModel.thumbnailUrl)
            tvSearchRelatedSearchWordTitle.text = relateRecommendProductModel.engTitle
            tvSearchRelatedSearchWordPrice.text = relateRecommendProductModel.price
        }
    }
}
