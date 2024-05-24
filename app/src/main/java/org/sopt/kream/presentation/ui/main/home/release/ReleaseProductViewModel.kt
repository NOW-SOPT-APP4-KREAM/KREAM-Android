package org.sopt.kream.presentation.ui.main.home.release

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.kream.data.ServicePool
import org.sopt.kream.data.model.response.ResponseReleaseProductDto
import org.sopt.kream.data.service.ProductService.Companion.MEMBER_ID
import org.sopt.kream.domain.repository.ProductRepository
import org.sopt.kream.presentation.ui.model.Advertisement
import org.sopt.kream.presentation.ui.type.AdvertisementType
import org.sopt.kream.util.view.UiState

class ReleaseProductViewModel(
    private val productRepository: ProductRepository,
) : ViewModel() {
    val advertisements by mutableStateOf(generateDummyAdvertisement())
    private val authService by lazy { ServicePool.productService }

    private val _getReleaseProductState =
        MutableStateFlow<UiState<List<ResponseReleaseProductDto.ReleaseProductResponseDto>>>(UiState.Empty)

    val getReleaseProductState get() = _getReleaseProductState.asStateFlow()

    private val _postScrapState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val postScrapState get() = _postScrapState.asStateFlow()

    private val _deleteScrapState = MutableStateFlow<UiState<Int>>(UiState.Empty)

    private val _productList = MutableStateFlow<List<ResponseReleaseProductDto.ReleaseProductResponseDto>>(listOf())


    fun getReleaseProduct() {
        viewModelScope.launch {
            runCatching {
                authService.getReleaseProduct(MEMBER_ID)
            }.onSuccess {
                _getReleaseProductState.value = UiState.Success(it.data.releaseProducts)
                _productList.value = it.data.releaseProducts
            }.onFailure { exception: Throwable ->
                _getReleaseProductState.value = UiState.Error(exception.message)
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

    private fun generateDummyAdvertisement(): List<Advertisement> {
        return AdvertisementType.entries.mapIndexed { index, adEnum ->
            Advertisement(
                id = index,
                imgResource = adEnum.imgResource,
            )
        }
    }
}
