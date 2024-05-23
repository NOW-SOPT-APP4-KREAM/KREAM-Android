package org.sopt.kream.data.service

import org.sopt.kream.data.model.response.ResponseReleaseProductDto
import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ProductService {
    @GET("product")
    suspend fun getSearchProduct(
        @Query("findName") findName: String,
    ): BaseResponse<ResponseSearchProductDto>

    @GET("product/release")
    suspend fun getReleaseProduct(
        @Header("memberId") memberId: Int,
    ): BaseResponse<ResponseReleaseProductDto>

    @DELETE("product/release")
    suspend fun deleteScrap(
        @Header("memberId") memberId: Int,
    ): BaseResponse<Unit>
}
