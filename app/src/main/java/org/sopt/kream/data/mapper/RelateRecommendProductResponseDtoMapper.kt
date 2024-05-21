package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseSearchProductDto.RelateRecommendProductResponseDto
import org.sopt.kream.domain.model.RelateRecommendProductModel

fun RelateRecommendProductResponseDto.toRelateRecommendProductModel() =
    RelateRecommendProductModel(
        thumbnailUrl = this.thumbnailUrl,
        engTitle = this.engTitle,
        price = this.price,
    )
