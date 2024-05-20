package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchRelateRecommendProductListBinding
import org.sopt.kream.domain.model.RelateRecommendProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchRelateRecommendProductListAdapter() : ListAdapter<List<RelateRecommendProductModel>, SearchRelateRecommendProductListViewHolder>(
    ItemDiffCallback<List<RelateRecommendProductModel>>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.size == new.size },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchRelateRecommendProductListViewHolder =
        SearchRelateRecommendProductListViewHolder(
            ItemSearchRelateRecommendProductListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: SearchRelateRecommendProductListViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position])
    }
}
