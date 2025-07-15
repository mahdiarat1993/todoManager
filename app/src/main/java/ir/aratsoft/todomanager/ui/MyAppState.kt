package ir.aratsoft.todomanager.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.aratsoft.core.data.repository.AppDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberAppState(
    appDataRepository: AppDataRepository,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): AppState = remember(
    appDataRepository,
    navController,
    coroutineScope,
) {
    AppState(
        navController = navController,
        coroutineScope = coroutineScope,
        appDataRepository = appDataRepository
    )
}


@Stable
class AppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    appDataRepository: AppDataRepository
){
    val selectedLanguage = appDataRepository.selectedLanguage
        .stateIn(coroutineScope, SharingStarted.WhileSubscribed(5000), "en")
}

