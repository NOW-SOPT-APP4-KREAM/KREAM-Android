package org.sopt.kream.domain.model

data class ProductDetailModel(
    val thumbnailUrl: String,
    val price: String,
    val engTitle: String,
    val title: String,
    val recentPrice: String,
    val variablePrice: String,
    val variablePercent: String,
    val releasePrice: String,
    val modelNumber: String,
    val releaseDate: String,
    val styleCount: String,
    val styles: List<ProductDetailStyleModel>,
    val isScrap: Boolean,
    val scrapCount: String,
    val cellPrice: String,
)