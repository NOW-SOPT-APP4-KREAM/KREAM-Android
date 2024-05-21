package org.sopt.kream.presentation.ui.main.home.release

import org.sopt.kream.R

data class Advertisement(
    val id: Int,
    val imgResource: Int,
)

enum class AdvertisementType(val imgResource: Int) {
    AD_01(R.drawable.img_view1_ad_01),
    AD_02(R.drawable.img_view1_ad_02),
    AD_03(R.drawable.img_view1_ad_03),
    AD_04(R.drawable.img_view1_ad_04)
}
