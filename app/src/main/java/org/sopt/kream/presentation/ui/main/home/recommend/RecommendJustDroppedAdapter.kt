package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendJustDroppedProductBinding
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendJustDroppedAdapter(
    private val navigateToProductDetail: (Int) -> Unit,
    private val postScrapProduct: (Int) -> Unit,
    private val deleteScrapProduct: (Int) -> Unit,
) : ListAdapter<
        RecommendJustDroppedProductModel,
        RecommendJustDroppedViewHolder,
        >(
        ItemDiffCallback<RecommendJustDroppedProductModel>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new },
        ),
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendJustDroppedViewHolder =
        RecommendJustDroppedViewHolder(
            ItemRecommendJustDroppedProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            navigateToProductDetail,
            postScrapProduct,
            deleteScrapProduct,
        )

    override fun onBindViewHolder(
        holder: RecommendJustDroppedViewHolder,
        position: Int,
    ) {
        holder.onBind(
            recommendJustDroppedProductModel = currentList[position],
            position = position,
        )
    }
}
