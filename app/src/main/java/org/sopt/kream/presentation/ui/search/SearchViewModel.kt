package org.sopt.kream.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.kream.domain.model.RelatedSearchWordModel
import org.sopt.kream.domain.model.SearchProductModel
import org.sopt.kream.domain.repository.ProductRepository
import org.sopt.kream.util.view.UiState

class SearchViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _searchProductState = MutableStateFlow<UiState<SearchProductModel>>(UiState.Empty)
    val searchProductState get() = _searchProductState.asStateFlow()

    private val _relatedSearchWordList = listOf(
        RelatedSearchWordModel("아디다스 클라우드"),
        RelatedSearchWordModel("아디다스 화이트"),
        RelatedSearchWordModel("아디다스 자메이카"),
        RelatedSearchWordModel("아디다스 박스"),
        RelatedSearchWordModel("아디다스 00s"),
        RelatedSearchWordModel("아디다스 코어"),
        RelatedSearchWordModel("아디다스 네이버"),
        RelatedSearchWordModel("아디다스 에어포스"),
        RelatedSearchWordModel("아디다스 클래식"),
        RelatedSearchWordModel("아디다스 인디고")
    )

    val relatedSearchWordList get() = _relatedSearchWordList

    fun getSearchProduct(findName: String) {
        viewModelScope.launch {
            _searchProductState.value = UiState.Loading
            productRepository.getSearchProduct(findName = findName).onSuccess { searchProductModel ->
                _searchProductState.value = UiState.Success(searchProductModel)
            }.onFailure { exception: Throwable ->
                _searchProductState.value = UiState.Error(exception.message)
            }
        }
    }
}