package org.sopt.kream.domain.repository

import org.sopt.kream.domain.model.ProductDetailModel
import org.sopt.kream.domain.model.RecommendProductModel
import org.sopt.kream.domain.model.SearchProductModel

interface ProductRepository {
    suspend fun getSearchProduct(findName: String): Result<SearchProductModel>

    suspend fun getProductDetail(productId: Int): Result<ProductDetailModel>

    suspend fun getRecommendProduct(): Result<RecommendProductModel>

    suspend fun postScrap(productId: Int): Result<Unit>

    suspend fun deleteScrap(productId: Int): Result<Unit>
}
