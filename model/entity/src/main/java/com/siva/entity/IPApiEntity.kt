package com.siva.entity

data class IPApiEntity(
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
) {
    constructor() : this(
        ip = "2409:40f4:101f:7cc3:d8ac:e6cd:883c:8786",
        network = "2409:40f4:1000::/38",
        version = "IPv6",
        city = "Coimbatore",
        region = "Tamil Nadu",
        country_name = "India",
        postal = "641014",
        latitude = 11.0142,
        longitude = 76.9941,
        timezone = "Asia/Kolkata",
        currency = "INR",
        org = "Reliance Jio Infocomm Limited",
    )
}

