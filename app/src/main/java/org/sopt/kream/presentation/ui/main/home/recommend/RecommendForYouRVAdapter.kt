package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendForYouProductBinding

class RecommendForYouRVAdapter(list: List<RecommendViewModel.ForYou>, page: Int) : RecyclerView.Adapter<RecommendForYouRVAdapter.ViewHolder>() {
    private val item = list
    private val startPosition = page * 6

    inner class ViewHolder(private val binding: ItemRecommendForYouProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecommendViewModel.ForYou) {
            binding.ivForYou.setImageResource(item.thumbnailUrl)
            binding.tvForYouBrand.text = item.brandTitle
            binding.tvForYouProduct.text = item.engTitle
            binding.tvForYouPrice.text = item.price
            binding.tvForYouTransaction.text = item.transactionCount
            binding.tvForYouSee.visibility = View.INVISIBLE
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = ItemRecommendForYouProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(item[position + startPosition])
    }

    override fun getItemCount(): Int = 6
}
