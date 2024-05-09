package org.sopt.kream.data.datasourceimpl

import org.sopt.kream.data.ServicePool
import org.sopt.kream.data.datasource.DummyRemoteDataSource
import org.sopt.kream.data.model.response.ResponseGetDummyUserListDto

class DummyRemoteDataSourceImpl : DummyRemoteDataSource {
    private val dummyService = ServicePool.dummyService

    override suspend fun getDummyUserList(page: Int): ResponseGetDummyUserListDto = dummyService.getDummyListUserList(page = page)
}
