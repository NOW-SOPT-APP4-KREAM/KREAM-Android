package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendCircleMenuBinding
import org.sopt.kream.presentation.ui.type.RecommendCircleMenuType
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendCircleMenuAdapter() : ListAdapter<RecommendCircleMenuType, RecommendCircleMenuViewHolder>(
    ItemDiffCallback<RecommendCircleMenuType>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.name == new.name },
    ),
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendCircleMenuViewHolder {
        val binding = ItemRecommendCircleMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendCircleMenuViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecommendCircleMenuViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList.get(position))
    }
}
