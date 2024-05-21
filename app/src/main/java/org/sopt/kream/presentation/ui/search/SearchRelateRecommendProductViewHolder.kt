package org.sopt.kream.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.kream.databinding.ItemSearchRelateRecommendProductBinding
import org.sopt.kream.domain.model.RelateRecommendProductModel

class SearchRelateRecommendProductViewHolder(
    private val binding: ItemSearchRelateRecommendProductBinding,
    private val navigateToProductDetail: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(relateRecommendProductModel: RelateRecommendProductModel, position: Int) {
        with(binding) {
            ivSearchRelateRecommendProductThumbnail.load(relateRecommendProductModel.thumbnailUrl)
            tvSearchRelatedSearchWordTitle.text = relateRecommendProductModel.engTitle
            tvSearchRelatedSearchWordPrice.text = relateRecommendProductModel.price

            root.setOnClickListener {
                navigateToProductDetail(position)
            }
        }
    }
}
