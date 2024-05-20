package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendAdBinding

class RecommendViewPagerAdapter(val data: List<Int>) : RecyclerView.Adapter<RecommendViewPagerAdapter.ViewHolder>() {
    val item = data

    inner class ViewHolder(private val binding: ItemRecommendAdBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int) {
            binding.ivRecommendAd.setImageResource(item)
        }
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = ItemRecommendAdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}
