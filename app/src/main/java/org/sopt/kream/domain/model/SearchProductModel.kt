package org.sopt.kream.domain.model

data class SearchProductModel(
    val searchFindProducts: List<SearchFindProductModel>,
    val relateRecommendProducts: List<RelateRecommendProductModel>
)