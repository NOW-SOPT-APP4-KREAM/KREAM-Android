package org.sopt.kream.presentation.ui.productdetail

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemProductDetailInfoBinding
import org.sopt.kream.presentation.model.ProductDetailInfo
import org.sopt.kream.util.context.stringOf
import org.sopt.kream.util.int.toPx

class ProductDetailInfoViewHolder(
    private val binding: ItemProductDetailInfoBinding,
    private val context: Context,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        productDetailInfoModel: ProductDetailInfo,
        isLast: Boolean,
    ) {
        with(binding) {
            tvProductDetailInfoTitle.text = context.stringOf(productDetailInfoModel.productDetailInfoType.titleStringRes)
            tvProductDetailInfoContent.text = productDetailInfoModel.content
            tvProductDetailInfoAdditionalContent.text = productDetailInfoModel.additionalContent
            ivProductDetailInfoAdditionalContent.visibility = if (productDetailInfoModel.additionalContent.isNullOrEmpty()) View.INVISIBLE else View.VISIBLE
            (viewProductDetailInfo.layoutParams as? ViewGroup.MarginLayoutParams)?.run {
                marginStart = productDetailInfoModel.productDetailInfoType.margin.toPx()
                viewProductDetailInfo.layoutParams = this
            }
            if (isLast) {
                viewProductDetailInfo.visibility = View.INVISIBLE
            }
        }
    }
}
