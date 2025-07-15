package ir.aratsoft.todomanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint
import ir.aratsoft.core.data.repository.AppDataRepository
import ir.aratsoft.todomanager.core.designsystem.theme.AppTheme
import ir.aratsoft.todomanager.ui.MyApp
import ir.aratsoft.todomanager.ui.rememberAppState
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appDataRepository: AppDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberAppState(
                appDataRepository = appDataRepository
            )
            AppTheme(selectedLanguage =  appState.selectedLanguage.collectAsState().value) {

                MyApp(appState)
            }
        }
    }
}
