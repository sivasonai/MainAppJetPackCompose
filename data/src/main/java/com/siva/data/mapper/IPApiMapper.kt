package com.siva.data.mapper

import com.siva.apiresponse.IPApiResponse
import com.siva.data.utils.Mapper
import com.siva.entity.IPApiEntity
import javax.inject.Inject

class IPApiMapper @Inject constructor() : Mapper<IPApiResponse, IPApiEntity> {
    override fun mapFromApiResponse(type: IPApiResponse): IPApiEntity {
        return IPApiEntity(
            ip = type.ip ?: "2409:40f4:101f:7cc3:d8ac:e6cd:883c:8786",
            network = type.network ?: "2409:40f4:1000::/38",
            version = type.version ?: "IPv6",
            city = type.city ?: "Coimbatore",
            region = type.region ?: "Tamil Nadu",
            country_name = type.country_name ?: "India",
            postal = type.postal ?: "641014",
            latitude = type.latitude ?: 11.0142,
            longitude = type.longitude ?: 76.9941,
            timezone = type.timezone ?: "Asia/Kolkata",
            currency = type.currency ?: "INR",
            org = type.org ?: "Reliance Jio Infocomm Limited",
        )
    }
}