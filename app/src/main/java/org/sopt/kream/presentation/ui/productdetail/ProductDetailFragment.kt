package org.sopt.kream.presentation.ui.productdetail

import android.os.Bundle
import android.view.View
import org.sopt.kream.databinding.FragmentProductDetailBinding
import org.sopt.kream.presentation.ui.type.ProductDetailButtonType
import org.sopt.kream.util.base.BindingFragment

class ProductDetailFragment : BindingFragment<FragmentProductDetailBinding>({ FragmentProductDetailBinding.inflate(it) }) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        with(binding) {
            btnProductDetailBottomPurchase.setProductDetailButtonType(ProductDetailButtonType.PURCHASE)
            btnProductDetailBottomSale.setProductDetailButtonType(ProductDetailButtonType.SALE)
            btnProductDetailBottomSale.priceTextView.text = "148,000원"
            tvProductDetailBottomScrap.text = "11.4만"
            btnProductDetailBottomPurchase.priceTextView.text = "129,000원"
        }
    }
}
