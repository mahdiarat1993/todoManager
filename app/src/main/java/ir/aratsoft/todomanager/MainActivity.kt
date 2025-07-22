package ir.aratsoft.todomanager

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.aratsoft.todomanager.core.data.local.AppDataStore
import ir.aratsoft.todomanager.core.designsystem.theme.AppTheme
import ir.aratsoft.todomanager.ui.MyApp
import ir.aratsoft.todomanager.ui.rememberAppState
import ir.aratsoft.todomanager.util.LanguageUtils
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import androidx.core.graphics.drawable.toDrawable
import ir.aratsoft.todomanager.core.designsystem.theme.scrimDark


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            val appState = rememberAppState(
//                appDataRepository = appDataRepository
            )
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
//            AppTheme(selectedLanguage =  viewModel.selectedLanguage.collectAsState().value) {
            AppTheme(selectedLanguage = viewModel.selectedLanguage.collectAsState().value) {

                    MyApp(appState, language = viewModel.selectedLanguage.collectAsState().value)
            }
        }
    }

//    override fun attachBaseContext(base: Context) {
//        val defaultLang = runBlocking {
//            viewModel.selectedLanguage.value
//        }
//
//        val contextWithLang = LanguageUtils.applyAppLanguage(base, defaultLang)
//
//        super.attachBaseContext(contextWithLang)
//    }



}
