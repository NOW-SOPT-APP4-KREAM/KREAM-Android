package org.sopt.kream.data.datasourceimpl

import org.sopt.kream.data.ServicePool
import org.sopt.kream.data.datasource.ProductRemoteDataSource
import org.sopt.kream.data.model.request.RequestDeleteScrapDto
import org.sopt.kream.data.model.request.RequestPostScrapDto
import org.sopt.kream.data.model.response.ResponseProductDetailDto
import org.sopt.kream.data.model.response.ResponseRecommendProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import org.sopt.kream.util.base.NullableBaseResponse

class ProductRemoteDataSourceImpl : ProductRemoteDataSource {
    private val productService = ServicePool.productService

    override suspend fun getSearchProduct(findName: String): BaseResponse<ResponseSearchProductDto> = productService.getSearchProduct(findName = findName)

    override suspend fun getProductDetail(productId: Int): BaseResponse<ResponseProductDetailDto> = productService.getProductDetail(productId = productId)

    override suspend fun getRecommendProduct(): BaseResponse<ResponseRecommendProductDto> = productService.getRecommendProduct()

    override suspend fun postScrap(productId: Int): NullableBaseResponse<Unit> = productService.postScrap(request = RequestPostScrapDto(productId))

    override suspend fun deleteScrap(productId: Int): NullableBaseResponse<Unit> = productService.deleteScrap(request = RequestDeleteScrapDto(productId))
}
