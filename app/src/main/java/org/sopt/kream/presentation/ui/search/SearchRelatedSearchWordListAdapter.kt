package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchRelatedSearchWordListBinding
import org.sopt.kream.domain.model.RelatedSearchWordModel
import org.sopt.kream.util.view.ItemDiffCallback

class SearchRelatedSearchWordListAdapter() : ListAdapter<List<RelatedSearchWordModel>, SearchRelatedSearchWordListViewHolder>(
    ItemDiffCallback<List<RelatedSearchWordModel>>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.size == new.size },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchRelatedSearchWordListViewHolder =
        SearchRelatedSearchWordListViewHolder(
            ItemSearchRelatedSearchWordListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: SearchRelatedSearchWordListViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position])
    }
}
