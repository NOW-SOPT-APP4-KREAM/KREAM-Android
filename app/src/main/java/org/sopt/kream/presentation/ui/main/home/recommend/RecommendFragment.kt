package org.sopt.kream.presentation.ui.main.home.recommend

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import org.sopt.kream.R
import org.sopt.kream.databinding.FragmentRecommendBinding
import org.sopt.kream.util.base.BindingFragment

class RecommendFragment : BindingFragment<FragmentRecommendBinding>({ FragmentRecommendBinding.inflate(it) }) {
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        initBtnProductDetail()
    }

    private fun initBtnProductDetail() {
        binding.btnToProductDetail.setOnClickListener {
            findNavController().navigate(R.id.action_recommend_to_product_detail)
        }
    }
}