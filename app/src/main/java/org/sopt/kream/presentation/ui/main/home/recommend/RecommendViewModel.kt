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

    private val circleMenu: List<String> =
        listOf(
            "KREAM 카드",
            "크림 드로우",
            "남성 추천",
            "여성 추천",
            "색다른 추천",
            "정가 아래",
            "스프링 세일!",
            "샤넬 최대 ~42%",
            "4월 혜택",
            "소니&슈프림 선물",
        )

    data class ForYou(
        val thumbnailUrl: Int,
        val brandTitle: String,
        val engTitle: String,
        val price: String,
        val transactionCount: String,
    )

    fun getAdImage(): List<Int> {
        return adImageList
    }

    fun getCircleMenu(): List<String> {
        return circleMenu
    }
}
