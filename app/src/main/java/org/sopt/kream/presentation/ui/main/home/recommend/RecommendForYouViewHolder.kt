package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.kream.databinding.ItemRecommendForYouProductBinding
import org.sopt.kream.domain.model.RecommendForYouProductModel

class RecommendForYouViewHolder(
    private val binding: ItemRecommendForYouProductBinding,
    private val navigateToProductDetail: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        recommendForYouProductModel: RecommendForYouProductModel,
        position: Int,
    ) {
        with(binding) {
            ivForYou.load(recommendForYouProductModel.thumbnailUrl)
            tvForYouBrand.text = recommendForYouProductModel.brandTitle
            tvForYouProduct.text = recommendForYouProductModel.engTitle
            tvForYouPrice.text = recommendForYouProductModel.price
            tvForYouTransaction.text = recommendForYouProductModel.transactionCount
            tvForYouSee.visibility = View.INVISIBLE

            root.setOnClickListener {
                navigateToProductDetail(position)
            }
        }
    }
}
