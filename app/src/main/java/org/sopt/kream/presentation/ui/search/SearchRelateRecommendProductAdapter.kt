package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchRelateRecommendProductBinding
import org.sopt.kream.domain.model.RelateRecommendProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchRelateRecommendProductAdapter(
    private val navigateToProductDetail: (Int) -> Unit
) : ListAdapter<RelateRecommendProductModel, SearchRelateRecommendProductViewHolder>(
    ItemDiffCallback<RelateRecommendProductModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.engTitle == new.engTitle },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchRelateRecommendProductViewHolder =
        SearchRelateRecommendProductViewHolder(
            ItemSearchRelateRecommendProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            navigateToProductDetail
        )

    override fun onBindViewHolder(
        holder: SearchRelateRecommendProductViewHolder,
        position: Int,
    ) {
        holder.onBind(relateRecommendProductModel = currentList[position], position = position)
    }
}
