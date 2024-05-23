package org.sopt.kream.data.repository

import org.sopt.kream.data.datasource.ProductRemoteDataSource
import org.sopt.kream.data.mapper.toRecommendProductModel
import org.sopt.kream.data.mapper.toProductDetailModel
import org.sopt.kream.data.mapper.toSearchProductModel
import org.sopt.kream.domain.model.RecommendProductModel
import org.sopt.kream.domain.model.ProductDetailModel
import org.sopt.kream.domain.model.SearchProductModel
import org.sopt.kream.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource,
) : ProductRepository {
    override suspend fun getSearchProduct(findName: String): Result<SearchProductModel> =
        runCatching {
            productRemoteDataSource.getSearchProduct(findName = findName).data.toSearchProductModel()
        }

    override suspend fun getProductDetail(productId: Int): Result<ProductDetailModel> =
        runCatching {
            productRemoteDataSource.getProductDetail(productId = productId).data.toProductDetailModel()
        }

    override suspend fun getRecommendProduct(memberId: Int): Result<RecommendProductModel> =
        runCatching {
            productRemoteDataSource.getRecommendProduct(memberId = memberId).data.toRecommendProductModel()
        }
}
