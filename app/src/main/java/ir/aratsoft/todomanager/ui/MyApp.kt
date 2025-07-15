package ir.aratsoft.todomanager.ui

import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.aratsoft.todomanager.MainActivityViewModel
import ir.aratsoft.todomanager.core.designsystem.theme.AppTheme
import ir.aratsoft.todomanager.navigation.AppNavHost

@Composable
fun MyApp(
    appState: AppState,
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
){
    Surface {
        AppNavHost(appState)
    }
}