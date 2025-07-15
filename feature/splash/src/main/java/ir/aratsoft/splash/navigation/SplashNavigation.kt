package ir.aratsoft.splash.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ir.aratsoft.splash.presentation.ui.screen.SplashScreen
import ir.aratsoft.splash.presentation.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable


@Serializable
data object SplashRoute

fun NavGraphBuilder.splashScreen(
//    navigateToHome: () -> Unit,
//    navigateToLogin: () -> Unit
) {
    composable<SplashRoute> {
        SplashScreen(
//                onNavigateToHome = navigateToHome,
//                onNavigateToLogin = navigateToLogin
        )
    }
}
