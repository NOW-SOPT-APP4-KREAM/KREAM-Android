package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendInstagramBinding
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendStyleAdapter() : ListAdapter<
    RecommendViewModel.Instagram,
    RecommendStyleViewHolder,
    >(
    ItemDiffCallback<RecommendViewModel.Instagram>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.id == new.id },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendStyleViewHolder =
        RecommendStyleViewHolder(
            ItemRecommendInstagramBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: RecommendStyleViewHolder,
        position: Int,
    ) {
        holder.onBind(
            recommendInstagram = currentList[position],
            position = position,
        )
    }
}
