package org.sopt.kream.presentation.ui.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.kream.domain.repository.DummyRepository

class DummyViewModel(
    private val dummyRepository: DummyRepository,
) : ViewModel() {
    fun getDummyUserList(page: Int = 2) {
        viewModelScope.launch {
            dummyRepository.getDummyUserList(page = page)
        }
    }
}
