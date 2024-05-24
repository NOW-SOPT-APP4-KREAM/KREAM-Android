package org.sopt.kream.data.service


import org.sopt.kream.data.model.request.RequestDeleteScrapDto

import org.sopt.kream.data.model.request.RequestPostScrapDto
import org.sopt.kream.data.model.response.ResponseProductDetailDto
import org.sopt.kream.data.model.response.ResponseRecommendProductDto

import org.sopt.kream.data.model.response.ResponseReleaseProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import retrofit2.http.Body

import retrofit2.http.DELETE

import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @GET("product")
    suspend fun getSearchProduct(
        @Query("findName") findName: String,
    ): BaseResponse<ResponseSearchProductDto>

    @GET("product/{productId}")
    suspend fun getProductDetail(
        @Header("memberId") memberId: Int = MEMBER_ID,
        @Path("productId") productId: Int,
    ): BaseResponse<ResponseProductDetailDto>

    @GET("product/release")
    suspend fun getReleaseProduct(
        @Header("memberId") memberId: Int,
    ): BaseResponse<ResponseReleaseProductDto>

    @HTTP(method = "DELETE", path = "scrap", hasBody = true)
    suspend fun deleteScrap(
        @Header("memberId") memberId: Int,
        requestDeleteScrapDto: RequestDeleteScrapDto,
    ): BaseResponse<Unit>

    @GET("product/recommend")
    suspend fun getRecommendProduct(
        @Header("memberId") memberId: Int,
    ): BaseResponse<ResponseRecommendProductDto>

    @POST("scrap")
    suspend fun postScrap(
        @Header("memberId") memberId: Int,
        @Body request: RequestPostScrapDto,
    ): BaseResponse<Unit>

    companion object {
        const val MEMBER_ID = 1
    }
}
