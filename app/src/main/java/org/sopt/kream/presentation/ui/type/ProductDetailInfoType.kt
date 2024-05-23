package org.sopt.kream.presentation.ui.type

import androidx.annotation.StringRes
import org.sopt.kream.R

enum class ProductDetailInfoType(
    @StringRes val titleStringRes: Int,
    val margin: Int
) {
    RECENT_PRICE(
        titleStringRes = R.string.product_detail_recent_price,
        margin = 20
    ),
    RELEASE_PRICE(
        titleStringRes = R.string.product_detail_release_price,
        margin = 35
    ),
    MODEL_NUMBER(
        titleStringRes = R.string.product_detail_model_number,
        margin = 22
    ),
    RELEASE_DATE(
        titleStringRes = R.string.product_detail_release_date,
        margin = 20
    )
}