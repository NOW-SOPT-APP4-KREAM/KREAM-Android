package org.sopt.kream.presentation.ui.productdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentProductDetailBinding
import org.sopt.kream.presentation.common.ViewModelFactory
import org.sopt.kream.presentation.model.ProductDetailInfo
import org.sopt.kream.presentation.ui.search.SearchFragment.Companion.PRODUCT_ID
import org.sopt.kream.presentation.type.ProductDetailButtonType
import org.sopt.kream.presentation.type.ProductDetailInfoType
import org.sopt.kream.util.base.BindingFragment
import org.sopt.kream.util.component.KreamProductDetailStyleImageView
import org.sopt.kream.util.view.UiState

class ProductDetailFragment : BindingFragment<FragmentProductDetailBinding>({ FragmentProductDetailBinding.inflate(it) }) {
    private val productDetailViewModel: ProductDetailViewModel by viewModels { ViewModelFactory() }
    private lateinit var productDetailInfoAdapter: ProductDetailInfoAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        productDetailViewModel.getProductDetail(getProductId() + 1)
        initLayout()
        initAdapter()
        setIvProductDetailBack()
        collectProductDetailState()
    }

    private fun initLayout() {
        with(binding) {
            btnProductDetailBottomPurchase.setProductDetailButtonType(ProductDetailButtonType.PURCHASE)
            btnProductDetailBottomSale.setProductDetailButtonType(ProductDetailButtonType.SALE)
        }
    }

    private fun initAdapter() {
        productDetailInfoAdapter = ProductDetailInfoAdapter()
        binding.rvProductDetail.adapter = productDetailInfoAdapter
    }

    private fun setIvProductDetailBack() {
        binding.ivProductDetailBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun collectProductDetailState() {
        productDetailViewModel.productDetailState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { productDetailState ->
                when (productDetailState) {
                    is UiState.Success -> {
                        with(binding) {
                            ivProductDetailThumbnail.load(productDetailState.data.thumbnailUrl)
                            tvProductDetailPrice.text = productDetailState.data.price
                            tvProductDetailEngTitle.text = productDetailState.data.engTitle
                            tvProductDetailTitle.text = productDetailState.data.title
                            tvProductDetailStyle.text = getString(R.string.product_style, productDetailState.data.styleCount)
                            ivProductDetailBottomScrap.setImageResource(if (productDetailState.data.isScrap) R.drawable.ic_saved_1_on_24 else R.drawable.ic_saved_1_off_24)
                            tvProductDetailBottomScrap.text = productDetailState.data.scrapCount
                            btnProductDetailBottomPurchase.priceTextView.text = productDetailState.data.price
                            btnProductDetailBottomSale.priceTextView.text = productDetailState.data.cellPrice

                            val productDetailStyleList: List<KreamProductDetailStyleImageView> = listOf(ivProductDetailStyleFirst, ivProductDetailStyleSecond, ivProductDetailStyleThird, ivProductDetailStyleFourth, ivProductDetailStyleFifth, ivProductDetailStyleSixth, ivProductDetailStyleSeventh, ivProductDetailStyleEight, ivProductDetailStyleNinth)

                            productDetailState.data.styles.onEachIndexed { index, productDetailStyleModel ->
                                productDetailStyleList[index].setImageViewData(productDetailStyleModel = productDetailStyleModel, isLast = index == (productDetailState.data.styles.size - 1))
                            }

                            if (productDetailState.data.styles.isEmpty()) {
                                viewProductDetailDeliveryInfo.background = null
                                tvProductDetailStyle.visibility = View.GONE
                                layoutProductDetailStyleUpload.visibility = View.GONE
                                tvProductDetailStyleMore.visibility = View.GONE
                                productDetailStyleList.onEach { kreamProductDetailStyleImageView ->
                                    kreamProductDetailStyleImageView.visibility = View.GONE
                                }
                            }

                            productDetailInfoAdapter.submitList(
                                listOf(
                                    ProductDetailInfo(
                                        productDetailInfoType = ProductDetailInfoType.RECENT_PRICE,
                                        content = productDetailState.data.recentPrice,
                                        additionalContent = productDetailState.data.variablePrice + productDetailState.data.variablePercent,
                                    ),
                                    ProductDetailInfo(
                                        productDetailInfoType = ProductDetailInfoType.RELEASE_PRICE,
                                        content = productDetailState.data.releasePrice,
                                    ),
                                    ProductDetailInfo(
                                        productDetailInfoType = ProductDetailInfoType.MODEL_NUMBER,
                                        content = productDetailState.data.modelNumber,
                                    ),
                                    ProductDetailInfo(
                                        productDetailInfoType = ProductDetailInfoType.RELEASE_DATE,
                                        content = productDetailState.data.releaseDate,
                                    ),
                                ),
                            )

                            var isScrap = productDetailState.data.isScrap
                            layoutProductDetailBottomScrap.setOnClickListener {
                                if (isScrap) {
                                    productDetailViewModel.deleteScrapProduct(getProductId() + 1)
                                    ivProductDetailBottomScrap.setImageResource(R.drawable.ic_saved_1_off_24)
                                    isScrap = false
                                } else {
                                    productDetailViewModel.postScrapProduct(getProductId() + 1)
                                    ivProductDetailBottomScrap.setImageResource(R.drawable.ic_saved_1_on_24)
                                    isScrap = true
                                }
                            }
                        }
                    }

                    else -> Unit
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun getProductId(): Int = requireArguments().getInt(PRODUCT_ID)
}
