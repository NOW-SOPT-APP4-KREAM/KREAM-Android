package org.sopt.kream.data.datasourceimpl

import org.sopt.kream.data.ServicePool
import org.sopt.kream.data.datasource.ProductRemoteDataSource
import org.sopt.kream.data.model.response.ResponseRecommendProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse

class ProductRemoteDataSourceImpl : ProductRemoteDataSource {
    private val productService = ServicePool.productService

    override suspend fun getSearchProduct(findName: String): BaseResponse<ResponseSearchProductDto> = productService.getSearchProduct(findName = findName)

    override suspend fun getRecommendProduct(memberId: Int): BaseResponse<ResponseRecommendProductDto> = productService.getRecommendProduct(memberId = memberId)
}
