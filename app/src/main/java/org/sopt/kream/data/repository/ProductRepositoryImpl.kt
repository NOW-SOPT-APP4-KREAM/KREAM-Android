package org.sopt.kream.data.repository

import org.sopt.kream.data.datasource.ProductRemoteDataSource
import org.sopt.kream.data.mapper.toSearchProductModel
import org.sopt.kream.domain.model.SearchProductModel
import org.sopt.kream.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource,
) : ProductRepository {
    override suspend fun getSearchProduct(findName: String): Result<SearchProductModel> =
        runCatching {
            productRemoteDataSource.getSearchProduct(findName = findName).data.toSearchProductModel()
        }

    override suspend fun deleteScrap(memberId: Int, productId: Int): Result<Unit> {
        return runCatching {
            productRemoteDataSource.deleteScrap(memberId, productId)
        }
    }
}
