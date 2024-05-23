package org.sopt.kream.presentation.ui.model

import org.sopt.kream.presentation.ui.type.ProductDetailInfoType

data class ProductDetailInfo(
    val productDetailInfoType: ProductDetailInfoType,
    val content: String,
    val additionalContent: String? = null,
)
