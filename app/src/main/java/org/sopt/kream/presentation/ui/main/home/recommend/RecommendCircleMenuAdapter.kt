package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendCircleMenuBinding

class RecommendCircleMenuAdapter(val list: List<String>) : RecyclerView.Adapter<RecommendCircleMenuAdapter.ViewHolder>() {
    val item = list

    inner class ViewHolder(private val binding: ItemRecommendCircleMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.tvCircleMenuTitle.text = item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = ItemRecommendCircleMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = list.size
}
