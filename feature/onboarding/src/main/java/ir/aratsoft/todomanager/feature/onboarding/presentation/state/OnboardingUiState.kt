package ir.aratsoft.todomanager.feature.onboarding.presentation.state

import ir.aratsoft.todomanager.feature.onboarding.R
import ir.aratsoft.todomanager.feature.onboarding.domain.model.OnboardingData
import kotlinx.coroutines.flow.StateFlow

data class OnboardingUiState(
    val currentPage: Int = 0,
    val isLastPage: Boolean = false,
    val isModalShow: Boolean = false,
    val onboardingPagerData : List<OnboardingData>,
    val appLang: String = "en"

)
