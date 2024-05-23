package org.sopt.kream.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDeleteScrapDto(
    @SerialName("productId")
    val productId: List<DeleteScrapResponseDto>,
) {
    @Serializable
    data class DeleteScrapResponseDto(
        @SerialName("status")
        val status: Int,
        @SerialName("message")
        val message: String,
        @SerialName("data")
        val data: String,
    )
}
