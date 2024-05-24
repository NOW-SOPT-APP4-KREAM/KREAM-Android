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
import org.sopt.kream.presentation.ui.model.Advertisement
import org.sopt.kream.presentation.ui.type.AdvertisementType
import org.sopt.kream.util.view.UiState

class ReleaseProductViewModel(
    private val repository: ProductRepository,
) : ViewModel() {
    val advertisements by mutableStateOf(generateDummyAdvertisement())
    private val authService by lazy { ServicePool.productService }

    private val _getReleaseProductState =
        MutableStateFlow<UiState<List<ResponseReleaseProductDto.ReleaseProductResponseDto>>>(UiState.Empty)

    private val _deleteScrapState =
        MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val getReleaseProductState get() = _getReleaseProductState.asStateFlow()
    val deleteScrapState get() = _deleteScrapState.asStateFlow()

    private val _productList = MutableStateFlow<List<ResponseReleaseProductDto.ReleaseProductResponseDto>>(listOf())

    val productList get() = _productList.asStateFlow()

    fun getReleaseProduct() {
        viewModelScope.launch {
            runCatching {
                authService.getReleaseProduct(2)
            }.onSuccess {
                _getReleaseProductState.value = UiState.Success(it.data.releaseProducts)
                _productList.value = it.data.releaseProducts
            }.onFailure { exception: Throwable ->
                _getReleaseProductState.value = UiState.Error(exception.message)
            }
        }
    }

    fun deleteScrap(productIndex: Int) {
        Log.d("okhttp", "hi 1")
        viewModelScope.launch {
            repository.deleteScrap(2, productIndex)
                .onSuccess {
                    Log.d("okhttp", "hi 3")
                    _deleteScrapState.value = UiState.Success(it)
                }.onFailure { exception: Throwable ->
                    Log.d("okhttp", "hi 4 : ${exception.message}")
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
