package com.siva.data.apiservice

import com.siva.apiresponse.IPApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("json/")
    suspend fun fetchIPApiDetails(): Response<IPApiResponse>
}