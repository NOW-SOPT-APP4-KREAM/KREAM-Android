package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.kream.R
import org.sopt.kream.databinding.ItemRecommendReleaseProductBinding
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel

class RecommendJustDroppedViewHolder(
    private val binding: ItemRecommendReleaseProductBinding,
    private val navigateToProductDetail: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    private var recommendJustDroppedAdapter: RecommendJustDroppedAdapter = RecommendJustDroppedAdapter(navigateToProductDetail)
    fun onBind(
        recommendJustDroppedProductModel: RecommendJustDroppedProductModel,
        position: Int,
    ) {
        with(binding) {
            ivReleaseProduct.load(recommendJustDroppedProductModel.thumbnailUrl)
            tvReleaseProductBrand.text = recommendJustDroppedProductModel.brandTitle
            tvReleaseProductName.text = recommendJustDroppedProductModel.engTitle
            tvReleaseProductPrice.text = recommendJustDroppedProductModel.price
            tvReleaseProductTransaction.text = recommendJustDroppedProductModel.transactionCount
            ivReleaseProductSaved.setImageResource(
                if (recommendJustDroppedProductModel.isScrap) R.drawable.ic_saved_2_on_24
                else R.drawable.ic_saved_2_off_24
            )
        }
    }
}
