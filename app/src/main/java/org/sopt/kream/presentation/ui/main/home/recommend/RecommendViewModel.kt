package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.lifecycle.ViewModel
import org.sopt.kream.R

class RecommendViewModel : ViewModel() {
    private val adImageList: List<Int> =
        listOf(
            R.drawable.img_recommend_ad_01,
            R.drawable.img_recommend_ad_02,
            R.drawable.img_recommend_ad_03,
            R.drawable.img_recommend_ad_04,
        )

    fun getAdImage(): List<Int> {
        return adImageList
    }
}
