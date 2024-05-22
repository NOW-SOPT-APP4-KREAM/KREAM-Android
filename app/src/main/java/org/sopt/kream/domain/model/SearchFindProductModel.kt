package org.sopt.kream.domain.model

data class SearchFindProductModel(
    val thumbnailUrl: String,
    val brandTitle: String,
    val engTitle: String,
    val title: String,
    val price: String,
    val transactionCount: String,
    val scrapCount: String,
    val styleCount: String,
    val isFast: Boolean,
)
