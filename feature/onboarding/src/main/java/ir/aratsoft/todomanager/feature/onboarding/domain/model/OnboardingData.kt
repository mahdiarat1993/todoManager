package ir.aratsoft.todomanager.feature.onboarding.domain.model

import androidx.annotation.RawRes
import androidx.annotation.StringRes

data class OnboardingData(
    @RawRes val imageRes: Int,
    @StringRes val title: Int,
    @StringRes  val desc: Int
)
