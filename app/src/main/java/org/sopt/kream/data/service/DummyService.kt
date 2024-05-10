package org.sopt.kream.data.service

import org.sopt.kream.data.model.response.ResponseGetDummyUserListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DummyService {
    @GET("api/users")
    suspend fun getDummyListUserList(
        @Query("page") page: Int,
    ): ResponseGetDummyUserListDto
}
