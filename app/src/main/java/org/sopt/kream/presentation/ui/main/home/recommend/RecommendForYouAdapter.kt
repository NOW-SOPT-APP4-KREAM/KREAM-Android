package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.kream.databinding.ItemRecommendForYouProductBinding
import org.sopt.kream.domain.model.RecommendForYouProductModel
import org.sopt.kream.util.view.ItemDiffCallback

class RecommendForYouAdapter(
    private val navigateToProductDetail: (Int) -> Unit,
    private val page: Int,
) : ListAdapter<
        RecommendForYouProductModel,
        RecommendForYouViewHolder,
        >(
        ItemDiffCallback<RecommendForYouProductModel>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old.engTitle == new.engTitle },
        ),
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendForYouViewHolder =
        RecommendForYouViewHolder(
            ItemRecommendForYouProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            navigateToProductDetail,
        )

    override fun onBindViewHolder(
        holder: RecommendForYouViewHolder,
        position: Int,
    ) {
        holder.onBind(
            recommendForYouProductModel = currentList[page * 6 + position],
            position = position,
        )
    }
}
