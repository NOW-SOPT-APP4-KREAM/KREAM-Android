package org.sopt.kream.presentation.ui.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.kream.databinding.ItemSearchSearchFindProductBinding
import org.sopt.kream.domain.model.SearchFindProductModel

class SearchSearchFindProductViewHolder(
    private val binding: ItemSearchSearchFindProductBinding,
    private val navigateToProductDetail: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(searchFindProductModel: SearchFindProductModel, position: Int) {
        with(binding) {
            ivSearchSearchFindProductThumbnail.load(searchFindProductModel.thumbnailUrl)
            tvSearchSearchFindProductTransactionCount.text = searchFindProductModel.transactionCount
            tvSearchSearchFindProductBrandTitle.text = searchFindProductModel.brandTitle
            tvSearchSearchFindProductEngTitle.text = searchFindProductModel.engTitle
            tvSearchSearchFindProductTitle.text = searchFindProductModel.title
            includeSearchSearchFindProductFastDelivery.root.visibility = if (searchFindProductModel.isFast) View.VISIBLE else View.GONE
            tvSearchSearchFindProductPrice.text = searchFindProductModel.price
            tvSearchSearchFindProductScrap.text = searchFindProductModel.scrapCount
            tvSearchSearchFindProductStyle.text = searchFindProductModel.styleCount

            root.setOnClickListener {
                navigateToProductDetail(position)
            }
        }
    }
}
