package org.sopt.kream.domain.repository

import org.sopt.kream.domain.model.SearchProductModel

interface ProductRepository {
    suspend fun getSearchProduct(findName: String): Result<SearchProductModel>
}