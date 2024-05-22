package org.sopt.kream.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemSearchRelatedSearchWordListBinding
import org.sopt.kream.domain.model.RelatedSearchWordModel

class SearchRelatedSearchWordListViewHolder(
    private val binding: ItemSearchRelatedSearchWordListBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private var searchRelatedSearchWordAdapter: SearchRelatedSearchWordAdapter = SearchRelatedSearchWordAdapter()

    fun onBind(relatedSearchWordModelList: List<RelatedSearchWordModel>) {
        binding.rvSearchRelatedSearchWordList.adapter = searchRelatedSearchWordAdapter
        searchRelatedSearchWordAdapter.submitList(relatedSearchWordModelList)
    }
}
