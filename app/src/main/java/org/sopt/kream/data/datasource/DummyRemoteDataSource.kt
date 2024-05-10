package org.sopt.kream.data.datasource

import org.sopt.kream.data.model.response.ResponseGetDummyUserListDto

interface DummyRemoteDataSource {
    suspend fun getDummyUserList(page: Int): ResponseGetDummyUserListDto
}
