package org.sopt.kream.domain.model

data class RecommendProductModel(
    val recommendForYouProducts: List<RecommendForYouProductModel>,
    val recommendJustDroppedProducts: List<RecommendJustDroppedProductModel>,
)
