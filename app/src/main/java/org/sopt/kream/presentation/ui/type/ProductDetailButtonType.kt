package org.sopt.kream.presentation.ui.type

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import org.sopt.kream.R

enum class ProductDetailButtonType(
    @ColorRes val backgroundColorRes: Int,
    @ColorRes val middleBarColorRes: Int,
    @StringRes val titleText: Int,
    @StringRes val descriptionText: Int,
    @ColorRes val descriptionTextColorRes: Int
) {
    PURCHASE(
        backgroundColorRes = R.color.red02,
        middleBarColorRes = R.color.red04,
        titleText = R.string.product_purchase,
        descriptionText = R.string.product_instant_purchase_price,
        descriptionTextColorRes = R.color.red03
    ),
    SALE(
        backgroundColorRes = R.color.green03,
        middleBarColorRes = R.color.green06,
        titleText = R.string.product_sale,
        descriptionText = R.string.product_instant_sale_price,
        descriptionTextColorRes = R.color.green04
    )
}