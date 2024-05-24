package org.sopt.kream.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDeleteScrapDto(
    @SerialName("productId")
    val productId: Int,
)
