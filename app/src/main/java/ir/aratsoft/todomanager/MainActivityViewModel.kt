package ir.aratsoft.todomanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aratsoft.todomanager.core.domain.GetAppLangUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getAppLangUseCase: GetAppLangUseCase
) :ViewModel(){

    val selectedLanguage = getAppLangUseCase.invoke()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "en")
//    val selectedLanguage = getAppLangUseCase.invoke()
}