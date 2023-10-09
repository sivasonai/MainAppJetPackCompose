package com.siva.domain.usecase

import com.siva.domain.repository.IPApiRepository
import com.siva.domain.utils.ApiUseCaseNonParams
import com.siva.domain.utils.Result
import com.siva.entity.IPApiEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IPApiUseCase @Inject constructor(
    private val repository: IPApiRepository
) : ApiUseCaseNonParams<IPApiEntity> {
    override suspend fun execute(): Flow<Result<IPApiEntity>> {
        return repository.fetchIPDetails()
    }
}