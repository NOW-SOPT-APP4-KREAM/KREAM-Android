package org.sopt.kream.data.repository

import org.sopt.kream.data.datasource.DummyRemoteDataSource
import org.sopt.kream.data.model.response.ResponseGetDummyUserListDto
import org.sopt.kream.domain.model.DummyEntity
import org.sopt.kream.domain.repository.DummyRepository

class DummyRepositoryImpl(
    private val dummyRemoteDataSource: DummyRemoteDataSource,
) : DummyRepository {
    override suspend fun getDummyUserList(page: Int): Result<List<DummyEntity>> =
        runCatching {
            dummyRemoteDataSource.getDummyUserList(page = page).data.map { user: ResponseGetDummyUserListDto.User -> user.toDummyEntity() }
        }
}
