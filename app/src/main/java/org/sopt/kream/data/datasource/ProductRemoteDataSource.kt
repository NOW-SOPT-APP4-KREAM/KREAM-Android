package org.sopt.kream.data.datasource

import org.sopt.kream.data.model.response.ResponseSearchProductDto
import org.sopt.kream.util.base.BaseResponse

interface ProductRemoteDataSource {
    suspend fun getSearchProduct(findName: String): BaseResponse<ResponseSearchProductDto>
}