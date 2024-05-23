package org.sopt.kream.domain.repository

import org.sopt.kream.domain.model.ProductDetailModel
import org.sopt.kream.domain.model.RecommendProductModel
import org.sopt.kream.domain.model.SearchProductModel

interface ProductRepository {
    suspend fun getSearchProduct(findName: String): Result<SearchProductModel>

    suspend fun getProductDetail(productId: Int): Result<ProductDetailModel>

    suspend fun getRecommendProduct(memberId: Int): Result<RecommendProductModel>

    suspend fun postScrap(
        memberId: Int,
        productId: Int,
    ): Result<Unit>
}
