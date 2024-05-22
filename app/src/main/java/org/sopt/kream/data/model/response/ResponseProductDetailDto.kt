package org.sopt.kream.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseProductDetailDto(
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerialName("price")
    val price: String,
    @SerialName("engTitle")
    val engTitle: String,
    @SerialName("title")
    val title: String,
    @SerialName("recentPrice")
    val recentPrice: String,
    @SerialName("variablePrice")
    val variablePrice: String,
    @SerialName("variablePercent")
    val variablePercent: String,
    @SerialName("releasePrice")
    val releasePrice: String,
    @SerialName("modelNumber")
    val modelNumber: String,
    @SerialName("releaseDate")
    val releaseDate: String,
    @SerialName("styleCount")
    val styleCount: String,
    @SerialName("styles")
    val styles: List<ResponseProductDetailStyleDto>,
    @SerialName("isScrap")
    val isScrap: Boolean,
    @SerialName("scrapCount")
    val scrapCount: String,
    @SerialName("cellPrice")
    val cellPrice: String,
) {
    @Serializable
    data class ResponseProductDetailStyleDto(
        @SerialName("imageUrl")
        val imageUrl: String,
        @SerialName("isVideo")
        val isVideo: Boolean
    )
}