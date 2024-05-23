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
import org.sopt.kream.util.base.BaseResponse
import org.sopt.kream.util.view.UiState

class ReleaseProductViewModel : ViewModel() {
    val advertisements by mutableStateOf(generateDummyAdvertisement())
    private val authService by lazy { ServicePool.productService }

    private val _getReleaseProductState =
        MutableStateFlow<UiState<List<ResponseReleaseProductDto.ReleaseProductResponseDto>>>(UiState.Empty)
    private val _deleteScrap =
        MutableStateFlow<UiState<BaseResponse<Unit>>>(UiState.Empty)
    val getReleaseProductState get() = _getReleaseProductState.asStateFlow()
    fun getReleaseProduct() {
        viewModelScope.launch {
            runCatching {
                authService.getReleaseProduct(2)
            }.onSuccess {
                _getReleaseProductState.value = UiState.Success(it.data.releaseProducts)
            }.onFailure { exception: Throwable ->
                _getReleaseProductState.value = UiState.Error(exception.message)
            }
        }
    }
    fun deleteScrap(){
        viewModelScope.launch {
            runCatching {
                authService.deleteScrap(2)
            }.onSuccess { response ->
                _deleteScrap.value = UiState.Success(response)
            }.onFailure { exception: Throwable ->
                _deleteScrap.value = UiState.Error(exception.message)
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
