package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendCircleMenuBinding
import org.sopt.kream.presentation.ui.type.RecommendCircleMenuType
import kotlin.enums.EnumEntries

class RecommendCircleMenuAdapter(val list: EnumEntries<RecommendCircleMenuType>) : RecyclerView.Adapter<RecommendCircleMenuAdapter.ViewHolder>() {
    private val item = list

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
        holder.bind(item.get(position).menu)
    }

    override fun getItemCount(): Int = list.size
}
