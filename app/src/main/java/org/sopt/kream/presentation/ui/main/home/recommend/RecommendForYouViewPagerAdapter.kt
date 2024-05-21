package org.sopt.kream.presentation.ui.main.home.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.sopt.kream.databinding.FragmentRecommendForYouBinding
import org.sopt.kream.presentation.ui.main.home.recommend.RecommendViewModel.ForYou

class RecommendForYouViewPagerAdapter(val data: List<ForYou>) : RecyclerView.Adapter<RecommendForYouViewPagerAdapter.ViewHolder>() {
    val item = data

    inner class ViewHolder(private val binding: FragmentRecommendForYouBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: List<ForYou>,
            position: Int,
        ) {
            binding.rvForYouContent.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = RecommendForYouRVAdapter(item, position)
            }
        }
    }

    override fun getItemCount(): Int = item.size / 6

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(data, position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val binding = FragmentRecommendForYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}
