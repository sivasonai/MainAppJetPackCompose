package com.siva.domain.repository

import com.siva.domain.utils.Result
import com.siva.entity.IPApiEntity
import kotlinx.coroutines.flow.Flow


interface IPApiRepository {
    suspend fun fetchIPDetails(): Flow<Result<IPApiEntity>>
}