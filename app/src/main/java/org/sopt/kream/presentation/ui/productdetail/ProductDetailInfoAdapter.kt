package org.sopt.kream.presentation.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemProductDetailInfoBinding
import org.sopt.kream.presentation.model.ProductDetailInfo
import org.sopt.kream.util.view.ItemDiffCallback

class ProductDetailInfoAdapter() : ListAdapter<ProductDetailInfo, ProductDetailInfoViewHolder>(
    ItemDiffCallback<ProductDetailInfo>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.content == new.content },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductDetailInfoViewHolder =
        ProductDetailInfoViewHolder(
            ItemProductDetailInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            parent.context,
        )

    override fun onBindViewHolder(
        holder: ProductDetailInfoViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position], currentList.size - 1 == position)
    }
}
