package org.sopt.kream.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchProductDto(
    @SerialName("searchFindProductResponses")
    val searchFindProductResponses: List<SearchFindProductResponseDto>,
    @SerialName("relateRecommendProductResponses")
    val relateRecommendProductResponses: List<RelateRecommendProductResponseDto>,
) {
    @Serializable
    data class SearchFindProductResponseDto(
        @SerialName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerialName("brandTitle")
        val brandTitle: String,
        @SerialName("engTitle")
        val engTitle: String,
        @SerialName("title")
        val title: String,
        @SerialName("price")
        val price: String,
        @SerialName("transactionCount")
        val transactionCount: String,
        @SerialName("scrapCount")
        val scrapCount: String,
        @SerialName("styleCount")
        val styleCount: String,
        @SerialName("isFast")
        val isFast: Boolean,
    )

    @Serializable
    data class RelateRecommendProductResponseDto(
        @SerialName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerialName("engTitle")
        val engTitle: String,
        @SerialName("price")
        val price: String,
        @SerialName("isFast")
        val isFast: Boolean,
        @SerialName("scrapCount")
        val scrapCount: String,
        @SerialName("styleCount")
        val styleCount: String,
        @SerialName("isFreeDevliver")
        val isFreeDeliver: Boolean,
        @SerialName("isSave")
        val isSave: Boolean,
        @SerialName("isCoupon")
        val isCoupon: Boolean,
    )
}
