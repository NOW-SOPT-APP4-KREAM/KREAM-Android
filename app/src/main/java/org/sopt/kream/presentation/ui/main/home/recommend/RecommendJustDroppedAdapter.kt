package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendJustDroppedProductBinding
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendJustDroppedAdapter(
    private val navigateToProductDetail: (Int) -> Unit,
    private val recommendViewModel: RecommendViewModel,
    private val memberId: Int,
) : ListAdapter<
        RecommendJustDroppedProductModel,
        RecommendJustDroppedViewHolder,
        >(
        ItemDiffCallback<RecommendJustDroppedProductModel>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old.engTitle == new.engTitle },
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
            recommendViewModel,
            memberId,
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
