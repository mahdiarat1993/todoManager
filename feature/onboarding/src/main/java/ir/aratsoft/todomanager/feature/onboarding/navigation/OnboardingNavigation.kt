package ir.aratsoft.todomanager.feature.onboarding.navigation

import android.R.attr.onClick
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ir.aratsoft.todomanager.feature.onboarding.presentation.ui.screen.OnBoardingScreen
import kotlinx.serialization.Serializable


@Serializable
data object OnboardingRoute

fun NavController.navigateToOnboarding(navOptions: NavOptions? = null){
    navigate(OnboardingRoute)
}


fun NavGraphBuilder.onboardingScreen(
//    onClick: () -> Unit
) {
    composable<OnboardingRoute> {
        OnBoardingScreen(
//            onClick = onClick
        )
    }
}