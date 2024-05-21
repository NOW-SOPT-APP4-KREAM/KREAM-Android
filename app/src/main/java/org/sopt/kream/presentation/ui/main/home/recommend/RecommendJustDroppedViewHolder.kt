package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.kream.R
import org.sopt.kream.databinding.ItemRecommendJustDroppedProductBinding
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel

class RecommendJustDroppedViewHolder(
    private val binding: ItemRecommendJustDroppedProductBinding,
    private val navigateToProductDetail: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    private var recommendJustDroppedAdapter: RecommendJustDroppedAdapter = RecommendJustDroppedAdapter(navigateToProductDetail)

    fun onBind(
        recommendJustDroppedProductModel: RecommendJustDroppedProductModel,
        position: Int,
    ) {
        with(binding) {
            ivJustDroppedProduct.load(recommendJustDroppedProductModel.thumbnailUrl)
            tvJustDroppedProductBrand.text = recommendJustDroppedProductModel.brandTitle
            tvJustDroppedProductName.text = recommendJustDroppedProductModel.engTitle
            tvJustDroppedProductPrice.text = recommendJustDroppedProductModel.price
            tvJustDroppedProductTransaction.text = recommendJustDroppedProductModel.transactionCount
            ivJustDroppedProductScrap.setImageResource(
                if (recommendJustDroppedProductModel.isScrap) {
                    R.drawable.ic_saved_2_on_24
                } else {
                    R.drawable.ic_saved_2_off_24
                },
            )
            tvJustDroppedProductCoupon.visibility =
                if (recommendJustDroppedProductModel.isCoupon) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            tvJustDroppedProductSave.visibility =
                if (recommendJustDroppedProductModel.isSave) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            tvJustDroppedProductFreeDeliver.visibility =
                if (recommendJustDroppedProductModel.isFreeDeliver) {
                    View.VISIBLE
                } else {
                    View.INVISIBLE
                }
        }
    }
}
