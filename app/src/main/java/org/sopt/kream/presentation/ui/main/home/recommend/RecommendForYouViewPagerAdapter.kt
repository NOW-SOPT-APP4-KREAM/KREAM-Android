package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.FragmentRecommendForYouBinding
import org.sopt.kream.domain.model.RecommendForYouProductModel

class RecommendForYouViewPagerAdapter(
    private val navigateToProductDetail: (Int) -> Unit,
    private val data: List<RecommendForYouProductModel>,
) : RecyclerView.Adapter<RecommendForYouViewPagerViewHolder>() {
    override fun getItemCount(): Int = data.size / 6

    override fun onBindViewHolder(
        holder: RecommendForYouViewPagerViewHolder,
        position: Int,
    ) {
        holder.onBind(data, position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecommendForYouViewPagerViewHolder {
        val binding = FragmentRecommendForYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendForYouViewPagerViewHolder(binding, navigateToProductDetail)
    }
}
