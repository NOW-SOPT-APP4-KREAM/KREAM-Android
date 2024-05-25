package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseSearchProductDto.SearchFindProductResponseDto
import org.sopt.kream.domain.model.SearchFindProductModel

fun SearchFindProductResponseDto.toSearchFindProductModel() =
    SearchFindProductModel(
        thumbnailUrl = this.thumbnailUrl,
        brandTitle = this.brandTitle,
        engTitle = this.engTitle,
        title = this.title,
        price = this.price,
        transactionCount = this.transactionCount,
        scrapCount = this.scrapCount,
        styleCount = this.styleCount,
        isFast = this.isFast,
    )
