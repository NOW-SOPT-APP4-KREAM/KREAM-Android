package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchSearchFindProductListBinding
import org.sopt.kream.domain.model.SearchFindProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchSearchFindProductListAdapter(
    private val navigateToProductDetail: (Int) -> Unit,
) : ListAdapter<List<SearchFindProductModel>, SearchSearchFindProductListViewHolder>(
        ItemDiffCallback<List<SearchFindProductModel>>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old.size == new.size },
        ),
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchSearchFindProductListViewHolder =
        SearchSearchFindProductListViewHolder(
            ItemSearchSearchFindProductListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            navigateToProductDetail,
        )

    override fun onBindViewHolder(
        holder: SearchSearchFindProductListViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position])
    }
}
