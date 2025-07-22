package ir.aratsoft.todomanager.feature.onboarding.presentation.event

sealed class OnboardingEvent {
    data object StartLogin: OnboardingEvent()
    data object DisMissModal: OnboardingEvent()
    data object OnModalShow: OnboardingEvent()
    data class OnLangChange(val newValue: String): OnboardingEvent()
}
