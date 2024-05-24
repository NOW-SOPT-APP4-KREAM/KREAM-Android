package org.sopt.kream.presentation.type

import org.sopt.kream.R

enum class RecommendAdvertisementType(
    val advertisementList: List<Int>,
) {
    RECOMMEND_ADVERTISEMENT(
        listOf(
            R.drawable.img_recommend_ad_01,
            R.drawable.img_recommend_ad_02,
            R.drawable.img_recommend_ad_03,
            R.drawable.img_recommend_ad_04,
        ),
    ),
}
