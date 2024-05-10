package org.sopt.kream.domain.repository

import org.sopt.kream.domain.model.DummyEntity

interface DummyRepository {
    suspend fun getDummyUserList(page: Int): Result<List<DummyEntity>>
}
