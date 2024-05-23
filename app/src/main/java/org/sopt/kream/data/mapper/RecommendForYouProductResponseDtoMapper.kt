package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseRecommendProductDto.ResponseForYouProductDto
import org.sopt.kream.domain.model.RecommendForYouProductModel

fun ResponseForYouProductDto.toRecommendForYouProductModel() =
    RecommendForYouProductModel(
        thumbnailUrl = this.thumbnailUrl,
        brandTitle = this.brandTitle,
        engTitle = this.engTitle,
        price = this.price,
        transactionCount = this.transactionCount,
    )
