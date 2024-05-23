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

class ReleaseProductViewModel : ViewModel() {
    val advertisements by mutableStateOf(generateDummyAdvertisement())
    val authService by lazy { ServicePool.productService }

//    private val _getRememberAllState =
//        MutableStateFlow<UiState<List<ResponseRememberAllDto>>>(UiState.Empty)
//    val getRememberAllState get() = _getRememberAllState.asStateFlow()
//
//    fun getRememberAll() {
//        viewModelScope.launch {
//            _getRememberAllState.value = UiState.Loading
//            runCatching {
//                weLikedItRepository.getRememberAll()
//            }.onSuccess {
//                _getRememberAllState.value = UiState.Success(it)
//            }.onFailure { exception: Throwable ->
//                _getRememberAllState.value = UiState.Error(exception.message)
//            }
//        }

    private val _getReleaseProductState =
        MutableStateFlow<UiState<List<ResponseReleaseProductDto.ReleaseProductResponseDto>>>(UiState.Empty)
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

    private fun generateDummyAdvertisement(): List<Advertisement> {
        return AdvertisementType.entries.mapIndexed { index, adEnum ->
            Advertisement(
                id = index,
                imgResource = adEnum.imgResource,
            )
        }
    }
}
