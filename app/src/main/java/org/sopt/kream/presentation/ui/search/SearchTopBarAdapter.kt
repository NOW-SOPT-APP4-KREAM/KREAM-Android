package org.sopt.kream.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemSearchTopBarBinding
import org.sopt.kream.util.view.ItemDiffCallback

class SearchTopBarAdapter() : ListAdapter<Unit, SearchTopBarViewHolder>(
    ItemDiffCallback<Unit>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchTopBarViewHolder =
        SearchTopBarViewHolder(
            ItemSearchTopBarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: SearchTopBarViewHolder,
        position: Int,
    ) = Unit
}
