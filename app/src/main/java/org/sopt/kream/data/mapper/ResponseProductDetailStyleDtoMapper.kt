package org.sopt.kream.data.mapper

import org.sopt.kream.data.model.response.ResponseProductDetailDto.ResponseProductDetailStyleDto
import org.sopt.kream.domain.model.ProductDetailStyleModel

fun ResponseProductDetailStyleDto.toProductDetailStyleModel() = ProductDetailStyleModel(
    imageUrl = this.imageUrl,
    isVideo = this.isVideo
)