package org.sopt.kream.presentation

import androidx.annotation.StringRes
import org.sopt.kream.R

enum class HomeTabBarType(
    @StringRes val tabBarTextRes: Int,
    val isClickable: Boolean,
) {
    MD(
        tabBarTextRes = R.string.top_bar_main_md,
        isClickable = false,
    ),
    RECOMMEND(
        tabBarTextRes = R.string.top_bar_main_recommend,
        isClickable = true,
    ),
    RANKING(
        tabBarTextRes = R.string.top_bar_main_ranking,
        isClickable = false,
    ),
    INFORMATION(
        tabBarTextRes = R.string.top_bar_main_information,
        isClickable = true,
    ),
    LUXURY(
        tabBarTextRes = R.string.top_bar_main_luxury,
        isClickable = false,
    ),
    MALE(
        tabBarTextRes = R.string.top_bar_main_male,
        isClickable = false,
    ),
    FEMALE(
        tabBarTextRes = R.string.top_bar_main_female,
        isClickable = false,
    ),
    FOUND(
        tabBarTextRes = R.string.top_bar_main_found,
        isClickable = false,
    ),
    EVENT(
        tabBarTextRes = R.string.top_bar_main_event,
        isClickable = false,
    ),
}
