package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.lifecycle.ViewModel
import org.sopt.kream.R
import org.sopt.kream.domain.model.RecommendForYouProductModel
import org.sopt.kream.domain.model.RecommendJustDroppedProductModel

class RecommendViewModel : ViewModel() {
    private val forYouList: List<RecommendForYouProductModel> =
        listOf(
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                "Adidas",
                "Adidas Samba OG Cloud White",
                "132,000원",
                "거래 9만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                "Adidas",
                "Adidas Samba OG Black White Gum",
                "114,000원",
                "거래 7만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                "Adidas",
                "Adidas German Adicolor Classic 3-Stripes T-Shirt Off White - KR Sizing",
                "67,000원",
                "거래 3,176",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                "Adidas",
                "Adidas Adilette Clog Black White",
                "40,000원",
                "거래 1.9만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                "Adidas",
                "(W) Adidas Spezial Handball Clear Pink",
                "119,000원",
                "거래 2.1만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMzA2MjZfMjky/MDAxNjg3NzUyNzQ0ODQ0.LaS-vFQFqLWC0G6jq7iVZWnGkJKL5lAodL5M6PHzoskg.x1nC_GqewiguCwURCowo9FNxE9iPef7wAiBdQX620OMg.PNG/a_a750d14185cb4f3ba4421a6ce4a86c19.png?type=l",
                "Adidas",
                "Adidas Superstar Core Black White",
                "98,000원",
                "거래 6.1만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMTAzMDVfMjQz/MDAxNjE0OTE0NzIzMTQ4.tsuFUJtHGm4g4KE5EDikVMScORptOQqIB7afi1Nz2Qwg.sftz3YQOuw48xpNSJa1tV4uEsz5iU4mjIvpllgHWEn8g.PNG/p_8f7b72adbc924b5bbf7c670d55865e6b.png?type=l",
                "Adidas",
                "Adidas Samba OG Cloud White",
                "132,000원",
                "거래 9만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMTAzMDVfMjQz/MDAxNjE0OTE0NzIzMTQ4.tsuFUJtHGm4g4KE5EDikVMScORptOQqIB7afi1Nz2Qwg.sftz3YQOuw48xpNSJa1tV4uEsz5iU4mjIvpllgHWEn8g.PNG/p_8f7b72adbc924b5bbf7c670d55865e6b.png?type=l",
                "Adidas",
                "Adidas Samba OG Black White Gum",
                "114,000원",
                "거래 7만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMTAzMDVfMjQz/MDAxNjE0OTE0NzIzMTQ4.tsuFUJtHGm4g4KE5EDikVMScORptOQqIB7afi1Nz2Qwg.sftz3YQOuw48xpNSJa1tV4uEsz5iU4mjIvpllgHWEn8g.PNG/p_8f7b72adbc924b5bbf7c670d55865e6b.png?type=l",
                "Adidas",
                "Adidas German Adicolor Classic 3-Stripes T-Shirt Off White - KR Sizing",
                "67,000원",
                "거래 3,176",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMTAzMDVfMjQz/MDAxNjE0OTE0NzIzMTQ4.tsuFUJtHGm4g4KE5EDikVMScORptOQqIB7afi1Nz2Qwg.sftz3YQOuw48xpNSJa1tV4uEsz5iU4mjIvpllgHWEn8g.PNG/p_8f7b72adbc924b5bbf7c670d55865e6b.png?type=l",
                "Adidas",
                "Adidas Adilette Clog Black White",
                "40,000원",
                "거래 1.9만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMTAzMDVfMjQz/MDAxNjE0OTE0NzIzMTQ4.tsuFUJtHGm4g4KE5EDikVMScORptOQqIB7afi1Nz2Qwg.sftz3YQOuw48xpNSJa1tV4uEsz5iU4mjIvpllgHWEn8g.PNG/p_8f7b72adbc924b5bbf7c670d55865e6b.png?type=l",
                "Adidas",
                "(W) Adidas Spezial Handball Clear Pink",
                "119,000원",
                "거래 2.1만",
            ),
            RecommendForYouProductModel(
                "https://kream-phinf.pstatic.net/MjAyMTAzMDVfMjQz/MDAxNjE0OTE0NzIzMTQ4.tsuFUJtHGm4g4KE5EDikVMScORptOQqIB7afi1Nz2Qwg.sftz3YQOuw48xpNSJa1tV4uEsz5iU4mjIvpllgHWEn8g.PNG/p_8f7b72adbc924b5bbf7c670d55865e6b.png?type=l",
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
                isFreeDeliver = false,
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

    data class Instagram(
        val image: Int,
        val id: String,
    )

    private val instagramList: List<Instagram> =
        listOf(
            Instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            Instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            Instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            Instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
            Instagram(
                image = R.drawable.view2_img_style_01,
                id = "@zzz.myam",
            ),
        )

    fun getForYouList(): List<RecommendForYouProductModel> {
        return forYouList
    }

    fun getJustDropped(): List<RecommendJustDroppedProductModel> {
        return justDroppedList
    }

    fun getInstagram(): List<Instagram> {
        return instagramList
    }
}
