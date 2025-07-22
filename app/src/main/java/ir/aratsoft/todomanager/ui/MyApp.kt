package ir.aratsoft.todomanager.ui

import android.content.Context
import android.content.res.Configuration
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.aratsoft.todomanager.core.designsystem.component.NiaBackground
import ir.aratsoft.todomanager.navigation.AppNavHost
import ir.aratsoft.todomanager.util.LanguageUtils
import java.util.Locale
import androidx.compose.runtime.*

@Composable
fun MyApp(
    appState: AppState,
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
    language : String

){
//    val context = LocalContext.current

//    val currentLang by remember { mutableStateOf(Locale.getDefault().language) }

//    LaunchedEffect(language) {
//        LanguageUtils.applyAppLanguage(context, language)
//    }

    NiaBackground(modifier = modifier) {

        AppNavHost(appState)

    }
}
