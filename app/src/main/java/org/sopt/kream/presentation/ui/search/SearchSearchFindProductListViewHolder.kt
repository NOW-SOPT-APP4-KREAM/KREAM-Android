package org.sopt.kream.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemSearchSearchFindProductListBinding
import org.sopt.kream.domain.model.SearchFindProductModel

class SearchSearchFindProductListViewHolder(
    private val binding: ItemSearchSearchFindProductListBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private val searchSearchFindProductAdapter: SearchSearchFindProductAdapter = SearchSearchFindProductAdapter()

    fun onBind(searchFindProductModelList: List<SearchFindProductModel>) {
        binding.rvSearchSearchFindProductList.adapter = searchSearchFindProductAdapter
        searchSearchFindProductAdapter.submitList(searchFindProductModelList)
    }
}
