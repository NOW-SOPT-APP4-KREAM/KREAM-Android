package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendAdBinding

class RecommendAdViewPagerAdapter(private val data: List<Int>) : RecyclerView.Adapter<RecommendAdvertisementViewHolder>() {
    private val item = data

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(
        holder: RecommendAdvertisementViewHolder,
        position: Int,
    ) {
        holder.onBind(item[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendAdvertisementViewHolder {
        val binding = ItemRecommendAdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendAdvertisementViewHolder(binding)
    }
}
