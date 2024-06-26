package org.sopt.kream.data.datasource

import org.sopt.kream.data.model.response.ResponseProductDetailDto
import org.sopt.kream.data.model.response.ResponseRecommendProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import org.sopt.kream.util.base.NullableBaseResponse

interface ProductRemoteDataSource {
    suspend fun getSearchProduct(findName: String): BaseResponse<ResponseSearchProductDto>

    suspend fun getProductDetail(productId: Int): BaseResponse<ResponseProductDetailDto>

    suspend fun getRecommendProduct(): BaseResponse<ResponseRecommendProductDto>

    suspend fun postScrap(productId: Int): NullableBaseResponse<Unit>

    suspend fun deleteScrap(productId: Int): NullableBaseResponse<Unit>
}
