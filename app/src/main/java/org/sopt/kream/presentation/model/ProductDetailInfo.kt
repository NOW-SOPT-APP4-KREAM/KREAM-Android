package org.sopt.kream.presentation.model

import org.sopt.kream.presentation.type.ProductDetailInfoType

data class ProductDetailInfo(
    val productDetailInfoType: ProductDetailInfoType,
    val content: String,
    val additionalContent: String? = null,
)
