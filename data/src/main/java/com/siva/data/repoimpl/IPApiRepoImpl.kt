package com.siva.data.repoimpl

import com.siva.data.apiservice.ApiService
import com.siva.data.mapper.IPApiMapper
import com.siva.data.utils.NetworkBoundResource
import com.siva.data.utils.mapFromApiResponse
import com.siva.domain.repository.IPApiRepository
import com.siva.domain.utils.Result
import com.siva.entity.IPApiEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IPApiRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkBoundResources: NetworkBoundResource,
    private val ipApiMapper: IPApiMapper,
) : IPApiRepository {

    override suspend fun fetchIPDetails(): Flow<Result<IPApiEntity>> {
        return mapFromApiResponse(
            result = networkBoundResources.downloadData {
                apiService.fetchIPApiDetails()
            }, ipApiMapper
        )
    }
}