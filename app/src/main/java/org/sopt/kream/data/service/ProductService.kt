package org.sopt.kream.data.service

import org.sopt.kream.data.model.response.ResponseProductDetailDto
import org.sopt.kream.data.model.response.ResponseReleaseProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
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
        @Header("memberId") userid: Int,
    ): BaseResponse<ResponseReleaseProductDto>

    @DELETE("product/release")
    suspend fun deleteScrap(
        @Header("memberId") userid: Int,
    ): BaseResponse<ResponseReleaseProductDto>

    companion object {
        const val MEMBER_ID = 1
    }
}
