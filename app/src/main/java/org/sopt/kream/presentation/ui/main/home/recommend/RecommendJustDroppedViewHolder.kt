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
    private val postScrapProduct: (Int) -> Unit,
    private val deleteScrapProduct: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
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
            ivJustDroppedProductScrap.setImageResource(if (recommendJustDroppedProductModel.isScrap) R.drawable.ic_saved_2_on_24 else R.drawable.ic_saved_2_off_24)
            includeJustDroppedProductFastDelivery.tvRecommendFastDelivery.visibility = if (recommendJustDroppedProductModel.isFreeDeliver) View.VISIBLE else View.GONE
            includeJustDroppedProductFastDelivery.ivRecommendFastDelivery.visibility = if (recommendJustDroppedProductModel.isFreeDeliver) View.VISIBLE else View.GONE
            tvJustDroppedProductCoupon.visibility = if (recommendJustDroppedProductModel.isCoupon) View.VISIBLE else View.GONE
            tvJustDroppedProductSave.visibility = if (recommendJustDroppedProductModel.isSave) View.VISIBLE else View.GONE
            tvJustDroppedProductFreeDeliver.visibility = if (recommendJustDroppedProductModel.isFreeDeliver) View.VISIBLE else View.INVISIBLE
            root.setOnClickListener {
                navigateToProductDetail(position)
            }
            var isScrap = recommendJustDroppedProductModel.isScrap
            ivJustDroppedProductScrap.setOnClickListener {
                if (isScrap) {
                    deleteScrapProduct(position + 1)
                    ivJustDroppedProductScrap.setImageResource(R.drawable.ic_saved_1_off_24)
                    isScrap = false
                } else {
                    postScrapProduct(position + 1)
                    ivJustDroppedProductScrap.setImageResource(R.drawable.ic_saved_1_on_24)
                    isScrap = true
                }
            }
        }
    }
}
