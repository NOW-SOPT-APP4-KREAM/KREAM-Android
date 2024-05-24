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
    private val productRepository: ProductRepository,
) : ViewModel() {
    private val _productDetailState = MutableStateFlow<UiState<ProductDetailModel>>(UiState.Empty)
    val productDetailState get() = _productDetailState.asStateFlow()

    private val _postScrapState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val postScrapState get() = _postScrapState.asStateFlow()

    private val _deleteScrapState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val deleteScrapState get() = _postScrapState.asStateFlow()

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

    fun postScrapProduct(productId: Int) {
        viewModelScope.launch {
            _postScrapState.value = UiState.Loading
            productRepository.postScrap(productId = productId).onSuccess {
                _postScrapState.value = UiState.Success(productId)
            }.onFailure { exception: Throwable ->
                _postScrapState.value = UiState.Error(exception.message)
            }
        }
    }

    fun deleteScrapProduct(productId: Int) {
        viewModelScope.launch {
            _deleteScrapState.value = UiState.Loading
            productRepository.deleteScrap(productId = productId).onSuccess {
                _deleteScrapState.value = UiState.Success(productId)
            }.onFailure { exception: Throwable ->
                _deleteScrapState.value = UiState.Error(exception.message)
            }
        }
    }
}
