package org.sopt.kream.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemSearchRelateRecommendProductListBinding
import org.sopt.kream.domain.model.RelateRecommendProductModel

class SearchRelateRecommendProductListViewHolder(
    private val binding: ItemSearchRelateRecommendProductListBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private var searchRelateRecommendProductAdapter: SearchRelateRecommendProductAdapter = SearchRelateRecommendProductAdapter()

    fun onBind(relateRecommendProductModelListItemInfo: Pair<List<RelateRecommendProductModel>, String>) {
        binding.tvSearchRelateRecommendProductListSearchWord.text = relateRecommendProductModelListItemInfo.second
        binding.rvSearchRelatedProductList.adapter = searchRelateRecommendProductAdapter
        searchRelateRecommendProductAdapter.submitList(relateRecommendProductModelListItemInfo.first)
    }
}
