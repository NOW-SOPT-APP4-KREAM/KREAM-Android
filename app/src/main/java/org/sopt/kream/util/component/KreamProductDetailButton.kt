package org.sopt.kream.util.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import org.sopt.kream.databinding.ButtonDetailProductKreamBinding
import org.sopt.kream.presentation.ui.type.ProductDetailButtonType
import org.sopt.kream.util.view.colorOf
import org.sopt.kream.util.view.setBackgroundTint
import org.sopt.kream.util.view.stringOf

@SuppressLint("CustomViewStyleable")
class KreamProductDetailButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ButtonDetailProductKreamBinding
    val priceTextView get() = binding.tvBtnDetailProductKreamPrice

    init {
        binding = ButtonDetailProductKreamBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setProductDetailButtonType(productDetailButtonType: ProductDetailButtonType) {
        with(binding) {
            tvBtnDetailProductKreamTitle.text = stringOf(productDetailButtonType.titleText)
            tvBtnDetailProductKreamDescription.text = stringOf(productDetailButtonType.descriptionText)
            layoutBtnDetailProductKream.setBackgroundTint(productDetailButtonType.backgroundColorRes)
            viewBtnDetailProductKreamMiddleBar.setBackgroundTint(productDetailButtonType.middleBarColorRes)
            tvBtnDetailProductKreamDescription.setTextColor(colorOf(productDetailButtonType.descriptionTextColorRes))
        }
    }
}