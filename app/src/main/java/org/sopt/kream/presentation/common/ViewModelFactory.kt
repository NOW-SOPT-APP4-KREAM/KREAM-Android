package org.sopt.kream.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.kream.data.datasourceimpl.DummyRemoteDataSourceImpl
import org.sopt.kream.data.repository.DummyRepositoryImpl
import org.sopt.kream.presentation.ui.dummy.DummyViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DummyViewModel::class.java)) {
            return DummyViewModel(DummyRepositoryImpl(DummyRemoteDataSourceImpl())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
