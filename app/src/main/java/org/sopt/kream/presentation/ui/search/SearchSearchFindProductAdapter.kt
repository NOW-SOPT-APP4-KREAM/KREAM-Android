package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchSearchFindProductBinding
import org.sopt.kream.domain.model.SearchFindProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchSearchFindProductAdapter(
    private val navigateToProductDetail: (Int) -> Unit
) : ListAdapter<SearchFindProductModel, SearchSearchFindProductViewHolder>(
    ItemDiffCallback<SearchFindProductModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.engTitle == new.engTitle },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchSearchFindProductViewHolder =
        SearchSearchFindProductViewHolder(
            ItemSearchSearchFindProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            navigateToProductDetail
        )

    override fun onBindViewHolder(
        holder: SearchSearchFindProductViewHolder,
        position: Int,
    ) {
        holder.onBind(searchFindProductModel = currentList[position], position = position)
    }
}
