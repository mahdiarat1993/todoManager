package ir.aratsoft.todomanager.feature.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ir.aratsoft.todomanager.feature.splash.navigation.SplashRoute
import ir.aratsoft.todomanager.feature.splash.presentation.ui.screen.SplashScreen
import kotlinx.serialization.Serializable


@Serializable object SplashRoute



fun NavGraphBuilder.splashScreen(
    onNavigateToOnboarding: () -> Unit,
//    onNavigateToHome: () -> Unit
) {
    composable<SplashRoute> {
        SplashScreen(
            onNavigateToOnboarding = onNavigateToOnboarding,
//            onNavigateToHome = onNavigateToHome
        )
    }
}
