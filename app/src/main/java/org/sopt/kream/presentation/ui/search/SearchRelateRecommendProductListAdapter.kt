package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchRelateRecommendProductListBinding
import org.sopt.kream.domain.model.RelateRecommendProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchRelateRecommendProductListAdapter() : ListAdapter<Pair<List<RelateRecommendProductModel>, String>, SearchRelateRecommendProductListViewHolder>(
    ItemDiffCallback<Pair<List<RelateRecommendProductModel>, String>>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.second == new.second },
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
