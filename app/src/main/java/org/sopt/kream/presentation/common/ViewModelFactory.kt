package org.sopt.kream.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.kream.data.datasourceimpl.ProductRemoteDataSourceImpl
import org.sopt.kream.data.repository.ProductRepositoryImpl
import org.sopt.kream.presentation.ui.main.home.recommend.RecommendViewModel
import org.sopt.kream.presentation.ui.main.home.release.ReleaseProductViewModel
import org.sopt.kream.presentation.ui.productdetail.ProductDetailViewModel
import org.sopt.kream.presentation.ui.search.SearchViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(ProductRepositoryImpl(ProductRemoteDataSourceImpl())) as T
        } else if (modelClass.isAssignableFrom(ReleaseProductViewModel::class.java)) {
            return ReleaseProductViewModel(ProductRepositoryImpl(ProductRemoteDataSourceImpl())) as T
        } else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            return ProductDetailViewModel(ProductRepositoryImpl(ProductRemoteDataSourceImpl())) as T
        } else if (modelClass.isAssignableFrom(RecommendViewModel::class.java)) {
            return RecommendViewModel(ProductRepositoryImpl(ProductRemoteDataSourceImpl())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
