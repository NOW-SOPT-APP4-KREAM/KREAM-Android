package org.sopt.kream.presentation.ui.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.kream.domain.model.ProductDetailModel
import org.sopt.kream.domain.repository.ProductRepository
import org.sopt.kream.util.view.UiState

class ProductDetailViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _productDetailState = MutableStateFlow<UiState<ProductDetailModel>>(UiState.Empty)
    val productDetailState get() = _productDetailState.asStateFlow()

    fun getProductDetail(productId: Int) {
        viewModelScope.launch {
            _productDetailState.value = UiState.Loading
            productRepository.getProductDetail(productId = productId).onSuccess { productDetailModel ->
                _productDetailState.value = UiState.Success(productDetailModel)
            }.onFailure { exception: Throwable ->
                _productDetailState.value = UiState.Error(exception.message)
            }
        }
    }
}