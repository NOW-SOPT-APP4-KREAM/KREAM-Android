package org.sopt.kream.data.datasource

import org.sopt.kream.data.model.response.ResponseProductDetailDto
import org.sopt.kream.data.model.response.ResponseRecommendProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse

interface ProductRemoteDataSource {
    suspend fun getSearchProduct(findName: String): BaseResponse<ResponseSearchProductDto>


    suspend fun deleteScrap(memberId: Int,productId: Int):BaseResponse<Unit>

    suspend fun getProductDetail(productId: Int): BaseResponse<ResponseProductDetailDto>

    suspend fun getRecommendProduct(memberId: Int): BaseResponse<ResponseRecommendProductDto>

    suspend fun postScrap(

        memberId: Int,
        productId: Int,
    ): BaseResponse<Unit>
}
