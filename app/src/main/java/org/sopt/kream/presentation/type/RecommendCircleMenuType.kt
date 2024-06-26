package org.sopt.kream.presentation.type

import androidx.annotation.DrawableRes
import org.sopt.kream.R

enum class RecommendCircleMenuType(
    @DrawableRes val image: Int,
    val menu: Int,
) {
    KREAM_CARD(
        image = R.drawable.img_view2_cricle_01,
        menu = R.string.type_circle_menu_kream_card,
    ),
    CREAM_DRAW(
        image = R.drawable.img_view2_cricle_02,
        menu = R.string.type_circle_menu_kream_draw,
    ),
    MAN_RECOMMEND(
        image = R.drawable.img_view2_cricle_03,
        menu = R.string.type_circle_menu_man_recommend,
    ),
    WOMAN_RECOMMEND(
        image = R.drawable.img_view2_cricle_04,
        menu = R.string.type_circle_menu_woman_recommend,
    ),
    NEW_RECOMMEND(
        image = R.drawable.img_view2_cricle_05,
        menu = R.string.type_circle_menu_new_recommend,
    ),
    UNDER_PRICE(
        image = R.drawable.img_view2_cricle_06,
        menu = R.string.type_circle_menu_under_price,
    ),
    SPRING_SALE(
        image = R.drawable.img_view2_cricle_07,
        menu = R.string.type_circle_menu_spring_sale,
    ),
    CHANEL(
        image = R.drawable.img_view2_cricle_08,
        menu = R.string.type_circle_menu_chanel,
    ),
    MAY(
        image = R.drawable.img_view2_cricle_09,
        menu = R.string.type_circle_menu_may,
    ),
    SONY_SUPREME(
        image = R.drawable.img_view2_cricle_10,
        menu = R.string.type_circle_menu_sony_supreme,
    ),
}
