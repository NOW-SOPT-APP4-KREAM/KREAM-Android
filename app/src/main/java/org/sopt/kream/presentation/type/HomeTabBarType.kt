package org.sopt.kream.presentation.type

import androidx.annotation.StringRes
import org.sopt.kream.R

enum class HomeTabBarType(
    @StringRes val tabBarTextRes: Int,
    val isClickable: Boolean,
) {
    MD(
        tabBarTextRes = R.string.home_tap_bar_md,
        isClickable = false,
    ),
    RECOMMEND(
        tabBarTextRes = R.string.home_tap_bar_recommend,
        isClickable = true,
    ),
    RANKING(
        tabBarTextRes = R.string.home_tap_bar_ranking,
        isClickable = false,
    ),
    INFORMATION(
        tabBarTextRes = R.string.home_tap_bar_information,
        isClickable = true,
    ),
    LUXURY(
        tabBarTextRes = R.string.home_tap_bar_luxury,
        isClickable = false,
    ),
    MALE(
        tabBarTextRes = R.string.home_tap_bar_male,
        isClickable = false,
    ),
    FEMALE(
        tabBarTextRes = R.string.home_tap_bar_female,
        isClickable = false,
    ),
    FOUND(
        tabBarTextRes = R.string.home_tap_bar_found,
        isClickable = false,
    ),
    EVENT(
        tabBarTextRes = R.string.home_tap_bar_event,
        isClickable = false,
    ),
}
