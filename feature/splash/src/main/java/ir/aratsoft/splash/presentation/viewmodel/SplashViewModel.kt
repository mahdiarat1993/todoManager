package ir.aratsoft.splash.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aratsoft.core.data.local.AppDataStore
import ir.aratsoft.core.data.repository.AppDataRepository
import ir.aratsoft.splash.domain.usecase.IsOnboardingCompletedUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isOnboardingCompletedUseCase: IsOnboardingCompletedUseCase
) : ViewModel()
{
    val isFirstTime = isOnboardingCompletedUseCase().stateIn(viewModelScope,
        SharingStarted.Eagerly,false)
}