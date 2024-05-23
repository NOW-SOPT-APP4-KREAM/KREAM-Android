package org.sopt.kream.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReleaseProductDto(
    @SerialName("releaseProducts")
    val releaseProducts: List<ReleaseProductResponseDto>,
) {
    @Serializable
    data class ReleaseProductResponseDto(
        @SerialName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerialName("brandTitle")
        val brandTitle: String,
        @SerialName("engTitle")
        val engTitle: String,
        @SerialName("isScrap")
        var isScrap: Boolean,
        @SerialName("isUpdate")
        val isUpdate: Boolean,
        @SerialName("isNew")
        val isNew: Boolean,
    )
}
