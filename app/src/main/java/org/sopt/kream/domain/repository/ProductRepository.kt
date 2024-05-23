package org.sopt.kream.domain.repository

import org.sopt.kream.domain.model.SearchProductModel

interface ProductRepository {
    suspend fun getSearchProduct(findName: String): Result<SearchProductModel>

    suspend fun deleteScrap(
        memberId: Int,
        productId: Int,
    ): Result<Unit>
}
