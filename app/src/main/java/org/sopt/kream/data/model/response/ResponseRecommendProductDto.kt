package org.sopt.kream.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRecommendProductDto(
    @SerialName("forYouList")
    val forYouList: List<ResponseForYouProductDto>,
    @SerialName("justDropList")
    val justDropList: List<ResponseJustDroppedProductDto>,
) {
    @Serializable
    data class ResponseForYouProductDto(
        @SerialName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerialName("brandTitle")
        val brandTitle: String,
        @SerialName("engTitle")
        val engTitle: String,
        @SerialName("price")
        val price: String,
        @SerialName("transactionCount")
        val transactionCount: String,
    )

    @Serializable
    data class ResponseJustDroppedProductDto(
        @SerialName("thumbnailUrl")
        val thumbnailUrl: String,
        @SerialName("brandTitle")
        val brandTitle: String,
        @SerialName("engTitle")
        val engTitle: String,
        @SerialName("price")
        val price: String,
        @SerialName("transactionCount")
        val transactionCount: String,
        @SerialName("isScrap")
        val isScrap: Boolean,
        @SerialName("isFast")
        val isFast: Boolean,
        @SerialName("isFreeDeliver")
        val isFreeDeliver: Boolean,
        @SerialName("isSave")
        val isSave: Boolean,
        @SerialName("isCoupon")
        val isCoupon: Boolean,
    )
}
