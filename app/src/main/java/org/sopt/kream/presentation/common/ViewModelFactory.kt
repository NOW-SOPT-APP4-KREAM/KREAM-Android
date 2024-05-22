package org.sopt.kream.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.kream.data.datasourceimpl.DummyRemoteDataSourceImpl
import org.sopt.kream.data.datasourceimpl.ProductRemoteDataSourceImpl
import org.sopt.kream.data.repository.DummyRepositoryImpl
import org.sopt.kream.data.repository.ProductRepositoryImpl
import org.sopt.kream.domain.model.RecommendProductModel
import org.sopt.kream.presentation.ui.dummy.DummyViewModel
import org.sopt.kream.presentation.ui.main.home.recommend.RecommendViewModel
import org.sopt.kream.presentation.ui.search.SearchViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DummyViewModel::class.java)) {
            return DummyViewModel(DummyRepositoryImpl(DummyRemoteDataSourceImpl())) as T
        } else if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(ProductRepositoryImpl(ProductRemoteDataSourceImpl())) as T
        } else if (modelClass.isAssignableFrom(RecommendViewModel::class.java)) {
            return RecommendViewModel(ProductRepositoryImpl(ProductRemoteDataSourceImpl())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
