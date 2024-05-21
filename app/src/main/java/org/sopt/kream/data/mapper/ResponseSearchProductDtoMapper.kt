package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.domain.model.SearchProductModel

fun ResponseSearchProductDto.toSearchProductModel() = SearchProductModel(
    searchFindProducts = this.searchFindProductResponses.map { it.toSearchFindProductModel() },
    relateRecommendProducts = this.relateRecommendProductResponses.map { it.toRelateRecommendProductModel() }
)