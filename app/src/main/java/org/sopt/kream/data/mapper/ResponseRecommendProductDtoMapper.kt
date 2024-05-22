package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseRecommendProductDto
import org.sopt.kream.domain.model.RecommendProductModel

fun ResponseRecommendProductDto.toRecommendProductModel() =
    RecommendProductModel(
        recommendForYouProducts = this.forYouList.map { it.toRecommendForYouProductModel() },
        recommendJustDroppedProducts = this.justDropList.map { it.toRecommendJustDroppedProductModel() }
    )
