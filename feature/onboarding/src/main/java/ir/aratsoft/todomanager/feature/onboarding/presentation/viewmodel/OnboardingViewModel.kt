package ir.aratsoft.todomanager.feature.onboarding.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aratsoft.todomanager.core.data.local.LanguageChangeHelper
import ir.aratsoft.todomanager.core.domain.GetAppLangUseCase
import ir.aratsoft.todomanager.core.domain.SetAppLanguageUseCase
import ir.aratsoft.todomanager.feature.onboarding.domain.model.OnboardingData
import ir.aratsoft.todomanager.feature.onboarding.presentation.event.OnboardingEvent
import ir.aratsoft.todomanager.feature.onboarding.presentation.state.OnboardingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import ir.aratsoft.todomanager.feature.onboarding.R
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val setAppLanguageUseCase: SetAppLanguageUseCase,
    val getAppLangUseCase: GetAppLangUseCase,
) : ViewModel() {

    val selectedLang = getAppLangUseCase.invoke().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "en")

    private val totalPages = 3
    private val _uiState = MutableStateFlow(
        OnboardingUiState(
            onboardingPagerData = listOf(
                OnboardingData(
                    R.raw.first_slider,
                    R.string.feature_onboarding_first_slider_title,
                    R.string.feature_onboarding_first_slider_desc
                ),
                OnboardingData(
                    R.raw.second_slider,
                    R.string.feature_onboarding_second_slider_title,
                    R.string.feature_onboarding_second_slider_desc
                ),
                OnboardingData(
                    R.raw.third_slider,
                    R.string.feature_onboarding_third_slider_title,
                    R.string.feature_onboarding_third_slider_desc
                )
            )
        )
    )

    val uiState: StateFlow<OnboardingUiState> = _uiState
    init {
        Log.d("OnboardingVM", "isModalShow default: ${_uiState.value.isModalShow}")
    }
    fun onEvent(event: OnboardingEvent) {
        when (event) {

            is OnboardingEvent.StartLogin -> {
                _uiState.update { it.copy(isModalShow = true) }

//                _uiState.value = _uiState.value.copy(
//                    isModalShow = true
//                )
            }

            is OnboardingEvent.DisMissModal -> {
                _uiState.value = _uiState.value.copy(
                    isModalShow = false
                )
            }

            is OnboardingEvent.OnLangChange -> {
                viewModelScope.launch {
                    setAppLanguageUseCase.invoke(event.newValue)
                }
            }

            is OnboardingEvent.OnModalShow -> TODO()
        }
    }

}