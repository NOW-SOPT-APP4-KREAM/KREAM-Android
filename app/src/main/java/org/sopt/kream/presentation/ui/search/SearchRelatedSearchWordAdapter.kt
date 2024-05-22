package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchRelatedSearchWordBinding
import org.sopt.kream.domain.model.RelatedSearchWordModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchRelatedSearchWordAdapter() : ListAdapter<RelatedSearchWordModel, SearchRelatedSearchWordViewHolder>(
    ItemDiffCallback<RelatedSearchWordModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.searchWord == new.searchWord },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchRelatedSearchWordViewHolder =
        SearchRelatedSearchWordViewHolder(
            ItemSearchRelatedSearchWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: SearchRelatedSearchWordViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position])
    }
}
