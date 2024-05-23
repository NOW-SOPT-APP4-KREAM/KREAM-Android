package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendStyleBinding
import org.sopt.kream.presentation.model.InstagramModel
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendStyleAdapter() : ListAdapter<
        InstagramModel,
    RecommendStyleViewHolder,
    >(
    ItemDiffCallback<InstagramModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.id == new.id },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendStyleViewHolder =
        RecommendStyleViewHolder(
            ItemRecommendStyleBinding.inflate(
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
