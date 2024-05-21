package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.ItemRecommendCircleMenuBinding
import org.sopt.kream.presentation.ui.type.RecommendCircleMenuType
import kotlin.enums.EnumEntries

class RecommendCircleMenuAdapter(private val list: EnumEntries<RecommendCircleMenuType>) : RecyclerView.Adapter<RecommendCircleMenuViewHolder>() {
    private val item = list

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendCircleMenuViewHolder {
        val binding = ItemRecommendCircleMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendCircleMenuViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecommendCircleMenuViewHolder,
        position: Int,
    ) {
        holder.onBind(item.get(position).menu)
    }

    override fun getItemCount(): Int = list.size
}
