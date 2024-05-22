package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseRecommendProductDto.ResponseJustDroppedProductDto
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel

fun ResponseJustDroppedProductDto.toRecommendJustDroppedProductModel() =
    RecommendJustDroppedProductModel(
        thumbnailUrl = this.thumbnailUrl,
        brandTitle = this.brandTitle,
        engTitle = this.engTitle,
        price = this.price,
        transactionCount = this.transactionCount,
        isScrap = this.isScrap,
        isFast = this.isFast,
        isFreeDeliver = this.isFreeDeliver,
        isSave = this.isSave,
        isCoupon = this.isCoupon,
    )