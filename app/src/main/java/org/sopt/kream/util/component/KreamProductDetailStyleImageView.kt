package org.sopt.kream.util.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import org.sopt.kream.R
import org.sopt.kream.databinding.ViewImageStyleDetailProductKreamBinding
import org.sopt.kream.domain.model.ProductDetailStyleModel

@SuppressLint("CustomViewStyleable")
class KreamProductDetailStyleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ViewImageStyleDetailProductKreamBinding

    init {
        binding = ViewImageStyleDetailProductKreamBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setImageViewData(productDetailStyleModel: ProductDetailStyleModel, isLast: Boolean) {
        with(binding) {
            //ivProductDetailStyle.load(productDetailStyleModel.imageUrl)
            ivProductDetailStyleVideo.visibility = if (productDetailStyleModel.isVideo) View.VISIBLE else View.INVISIBLE

            if (isLast) ivProductDetailStyle.foreground = context.getDrawable(R.color.detail_foreground)
            tvProductDetailStyleMore.visibility = if (isLast) View.VISIBLE else View.INVISIBLE
            ivProductDetailStylePlus.visibility = if (isLast) View.VISIBLE else View.INVISIBLE
        }
    }
}