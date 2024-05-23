package org.sopt.kream.data.service

import org.sopt.kream.data.model.request.RequestPostScrapDto
import org.sopt.kream.data.model.response.ResponseRecommendProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductService {
    @GET("product")
    suspend fun getSearchProduct(
        @Query("findName") findName: String,
    ): BaseResponse<ResponseSearchProductDto>

    @GET("product/recommend")
    suspend fun getRecommendProduct(
        @Header("memberId") memberId: Int,
    ): BaseResponse<ResponseRecommendProductDto>

    @POST("scrap")
    suspend fun postScrap(
        @Header("memberId") memberId: Int,
        @Body request: RequestPostScrapDto,
    ): BaseResponse<Unit>
}
