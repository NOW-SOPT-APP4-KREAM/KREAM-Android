package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendAdvertisementBinding
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendAdvertisementViewPagerAdapter() : ListAdapter<Int, RecommendAdvertisementViewHolder>(
    ItemDiffCallback<Int>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new },
    ),
) {
    override fun onBindViewHolder(
        holder: RecommendAdvertisementViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendAdvertisementViewHolder {
        val binding = ItemRecommendAdvertisementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendAdvertisementViewHolder(binding)
    }
}
