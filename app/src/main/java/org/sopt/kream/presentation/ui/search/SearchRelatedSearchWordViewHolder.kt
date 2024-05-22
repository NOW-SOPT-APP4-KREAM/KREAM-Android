package org.sopt.kream.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemSearchRelatedSearchWordBinding
import org.sopt.kream.domain.model.RelatedSearchWordModel

class SearchRelatedSearchWordViewHolder(
    private val binding: ItemSearchRelatedSearchWordBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(relatedSearchWordModel: RelatedSearchWordModel) {
        binding.tvSearchRelatedSearchWord.text = relatedSearchWordModel.searchWord
    }
}
