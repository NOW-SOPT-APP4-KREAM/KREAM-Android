package org.sopt.kream.domain.model

data class RecommendJustDroppedProductModel(
    val thumbnailUrl: String,
    val brandTitle: String,
    val engTitle: String,
    val price: String,
    val transactionCount: String,
    var isScrap: Boolean,
    val isFast: Boolean,
    val isFreeDeliver: Boolean,
    val isSave: Boolean,
    val isCoupon: Boolean,
)
