package com.siva.apiresponse

data class IPApiResponse(
    val ip: String?,
    val network: String?,
    val version: String?,
    val city: String?,
    val region: String?,
    val country_name: String?,
    val postal: String?,
    val latitude: Double?,
    val longitude: Double?,
    val timezone: String?,
    val currency: String?,
    val org: String?,
)
