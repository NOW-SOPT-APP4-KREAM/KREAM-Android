package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendForYouBinding
import org.sopt.kream.domain.model.RecommendForYouProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendForYouViewPagerAdapter(
    private val navigateToProductDetail: (Int) -> Unit,
    private val navigateToSearch: (String) -> Unit,
) : ListAdapter<List<RecommendForYouProductModel>, RecommendForYouViewPagerViewHolder>(
    ItemDiffCallback<List<RecommendForYouProductModel>>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old[0].engTitle == new[0].engTitle },
    ),
) {
    override fun onBindViewHolder(
        holder: RecommendForYouViewPagerViewHolder,
        position: Int,
    ) {
        holder.onBind(currentList[position], position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendForYouViewPagerViewHolder {
        val binding = ItemRecommendForYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendForYouViewPagerViewHolder(binding, navigateToProductDetail, navigateToSearch)
    }
}
