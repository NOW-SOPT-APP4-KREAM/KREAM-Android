package org.sopt.kream.presentation.type

import androidx.annotation.StringRes
import org.sopt.kream.R

enum class SearchTabBarType(
    @StringRes val searchBarTextRes: Int,
    val isClickable: Boolean,
) {
    PRODUCT(
        searchBarTextRes = R.string.search_tap_bar_product,
        isClickable = true,
    ),
    STYLE(
        searchBarTextRes = R.string.search_tap_bar_style,
        isClickable = false,
    ),
    PROFILE(
        searchBarTextRes = R.string.search_tap_bar_profile,
        isClickable = false,
    ),
}
