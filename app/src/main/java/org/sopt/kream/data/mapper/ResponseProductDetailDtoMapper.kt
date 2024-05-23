package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseProductDetailDto
import org.sopt.kream.domain.model.ProductDetailModel

fun ResponseProductDetailDto.toProductDetailModel() =
    ProductDetailModel(
        thumbnailUrl = this.thumbnailUrl,
        price = this.price,
        engTitle = this.engTitle,
        title = this.title,
        recentPrice = this.recentPrice,
        variablePrice = this.variablePrice,
        variablePercent = this.variablePercent,
        releasePrice = this.releasePrice,
        modelNumber = this.modelNumber,
        releaseDate = this.releaseDate,
        styleCount = this.styleCount,
        styles =
            this.styles.map { responseProductDetailStyleDto ->
                responseProductDetailStyleDto.toProductDetailStyleModel()
            },
        isScrap = this.isScrap,
        scrapCount = this.scrapCount,
        cellPrice = this.cellPrice,
    )
