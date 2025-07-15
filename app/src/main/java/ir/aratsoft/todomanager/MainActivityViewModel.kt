package ir.aratsoft.todomanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aratsoft.core.data.repository.AppDataRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val appDataRepository: AppDataRepository
) :ViewModel(){

    val selectedLanguage = appDataRepository.selectedLanguage
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "en")

}