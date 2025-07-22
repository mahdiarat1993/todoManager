package ir.aratsoft.todomanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import ir.aratsoft.todomanager.feature.splash.navigation.SplashRoute
import ir.aratsoft.todomanager.feature.splash.navigation.splashScreen
import ir.aratsoft.todomanager.feature.onboarding.navigation.navigateToOnboarding
import ir.aratsoft.todomanager.feature.onboarding.navigation.onboardingScreen
import ir.aratsoft.todomanager.ui.AppState

@Composable
fun AppNavHost(
    appState: AppState,
//    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = SplashRoute,
        modifier = modifier,
    ) {

        splashScreen(
            onNavigateToOnboarding = navController::navigateToOnboarding
//            onNavigateToHome = navController.popBackStack()
        )

        onboardingScreen()
//        composable("splash") {
//            SplashScreen(
////                onNavigateNext = {
////                    appState.navController.navigate("home") {
////                        popUpTo("splash") { inclusive = true }
////                    }
////                }
//            )
//        }
//        composable("home") {
////            HomeScreen()
//        }
    }
}