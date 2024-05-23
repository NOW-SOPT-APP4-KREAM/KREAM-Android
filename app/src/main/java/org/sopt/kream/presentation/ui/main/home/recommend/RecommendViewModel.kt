package org.sopt.kream.presentation.ui.main.home.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.kream.R
import org.sopt.kream.domain.model.RecommendProductModel
import org.sopt.kream.domain.repository.ProductRepository
import org.sopt.kream.presentation.model.InstagramModel
import org.sopt.kream.util.view.UiState

class RecommendViewModel(
    private val productRepository: ProductRepository,
) : ViewModel() {
    private val _recommendProductState = MutableStateFlow<UiState<RecommendProductModel>>(UiState.Empty)
    val recommendProductState get() = _recommendProductState.asStateFlow()

    private val _instagramList =
        listOf(
            InstagramModel(
                image = R.drawable.img_recommend_style_01,
                id = "@zzz.myam",
            ),
            InstagramModel(
                image = R.drawable.img_recommend_style_02,
                id = "@minimin.0.0",
            ),
            InstagramModel(
                image = R.drawable.img_recommend_style_03,
                id = "@jyeo._.ni__",
            ),
            InstagramModel(
                image = R.drawable.img_recommend_style_04,
                id = "@_minsuk__",
            ),
            InstagramModel(
                image = R.drawable.img_recommend_style_05,
                id = "@hyobeen_0926",
            ),
        )
    val instagramList get() = _instagramList

    fun getRecommendProduct(memberId: Int) {
        viewModelScope.launch {
            _recommendProductState.value = UiState.Loading
            productRepository.getRecommendProduct(memberId = memberId).onSuccess { recommendProductModel ->
                _recommendProductState.value = UiState.Success(recommendProductModel)
            }.onFailure { exception: Throwable ->
                _recommendProductState.value = UiState.Error(exception.message)
            }
        }
    }
}
