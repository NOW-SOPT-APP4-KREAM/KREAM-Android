package org.sopt.kream.data.service

import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("product")
    suspend fun getSearchProduct(
        @Query("findName") findName: String,
    ): BaseResponse<ResponseSearchProductDto>
}
