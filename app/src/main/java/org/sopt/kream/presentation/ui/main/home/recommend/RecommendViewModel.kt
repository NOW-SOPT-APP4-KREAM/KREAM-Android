package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.lifecycle.ViewModel
import org.sopt.kream.R
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel

class RecommendViewModel : ViewModel() {
    private val adImageList: List<Int> =
        listOf(
            R.drawable.img_recommend_ad_01,
            R.drawable.img_recommend_ad_02,
            R.drawable.img_recommend_ad_03,
            R.drawable.img_recommend_ad_04,
        )

    private val circleMenu: List<String> =
        listOf(
            "KREAM 카드",
            "크림 드로우",
            "남성 추천",
            "여성 추천",
            "색다른 추천",
            "정가 아래",
            "스프링 세일!",
            "샤넬 최대 ~42%",
            "4월 혜택",
            "소니&슈프림 선물",
        )

    data class ForYou(
        val thumbnailUrl: Int,
        val brandTitle: String,
        val engTitle: String,
        val price: String,
        val transactionCount: String,
    )

    private val forYouList: List<ForYou> =
        listOf(
            ForYou(
                R.drawable.img_recommend_for_you_01,
                "Adidas",
                "Adidas Samba OG Cloud White",
                "132,000원",
                "거래 9만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_02,
                "Adidas",
                "Adidas Samba OG Black White Gum",
                "114,000원",
                "거래 7만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_03,
                "Adidas",
                "Adidas German Adicolor Classic 3-Stripes T-Shirt Off White - KR Sizing",
                "67,000원",
                "거래 3,176",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_04,
                "Adidas",
                "Adidas Adilette Clog Black White",
                "40,000원",
                "거래 1.9만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_05,
                "Adidas",
                "(W) Adidas Spezial Handball Clear Pink",
                "119,000원",
                "거래 2.1만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_06,
                "Adidas",
                "Adidas Superstar Core Black White",
                "98,000원",
                "거래 6.1만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_01,
                "Adidas",
                "Adidas Samba OG Cloud White",
                "132,000원",
                "거래 9만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_02,
                "Adidas",
                "Adidas Samba OG Black White Gum",
                "114,000원",
                "거래 7만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_03,
                "Adidas",
                "Adidas German Adicolor Classic 3-Stripes T-Shirt Off White - KR Sizing",
                "67,000원",
                "거래 3,176",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_04,
                "Adidas",
                "Adidas Adilette Clog Black White",
                "40,000원",
                "거래 1.9만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_05,
                "Adidas",
                "(W) Adidas Spezial Handball Clear Pink",
                "119,000원",
                "거래 2.1만",
            ),
            ForYou(
                R.drawable.img_recommend_for_you_06,
                "Adidas",
                "Adidas Superstar Core Black White",
                "98,000원",
                "거래 6.1만",
            ),
        )

    private val justDroppedList: List<RecommendJustDroppedProductModel> =
        listOf(
            RecommendJustDroppedProductModel(
                thumbnailUrl = "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                brandTitle = "Adidas",
                engTitle = "(W) Adidas Spezial Handball Clear Pink",
                price = "119,000원",
                transactionCount = "거래 2.1만",
                isScrap = false,
                isFast = true,
                isFreeDeliver = true,
                isSave = true,
                isCoupon = true,
            ),
            RecommendJustDroppedProductModel(
                thumbnailUrl = "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                brandTitle = "Adidas",
                engTitle = "(W) Adidas Spezial Handball Clear Pink",
                price = "119,000원",
                transactionCount = "거래 2.1만",
                isScrap = false,
                isFast = true,
                isFreeDeliver = true,
                isSave = true,
                isCoupon = true,
            ),
            RecommendJustDroppedProductModel(
                thumbnailUrl = "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                brandTitle = "Adidas",
                engTitle = "(W) Adidas Spezial Handball Clear Pink",
                price = "119,000원",
                transactionCount = "거래 2.1만",
                isScrap = false,
                isFast = true,
                isFreeDeliver = true,
                isSave = true,
                isCoupon = true,
            ),
            RecommendJustDroppedProductModel(
                thumbnailUrl = "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                brandTitle = "Adidas",
                engTitle = "(W) Adidas Spezial Handball Clear Pink",
                price = "119,000원",
                transactionCount = "거래 2.1만",
                isScrap = false,
                isFast = true,
                isFreeDeliver = true,
                isSave = true,
                isCoupon = true,
            ),
            RecommendJustDroppedProductModel(
                thumbnailUrl = "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                brandTitle = "Adidas",
                engTitle = "(W) Adidas Spezial Handball Clear Pink",
                price = "119,000원",
                transactionCount = "거래 2.1만",
                isScrap = false,
                isFast = true,
                isFreeDeliver = true,
                isSave = true,
                isCoupon = true,
            ),
        )

    data class instagram(
        val image: Int,
        val id: String,
    )

    private val instagramList: List<instagram> =
        listOf(
            instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
        )

    fun getAdImage(): List<Int> {
        return adImageList
    }

    fun getCircleMenu(): List<String> {
        return circleMenu
    }

    fun getForYouList(): List<ForYou> {
        return forYouList
    }

    fun getJustDropped(): List<RecommendJustDroppedProductModel> {
        return justDroppedList
    }

    fun getInstagram(): List<instagram> {
        return instagramList
    }
}
