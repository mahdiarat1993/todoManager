package ir.aratsoft.todomanager.feature.splash.presentation.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.aratsoft.todomanager.feature.splash.R
import ir.aratsoft.todomanager.feature.splash.presentation.viewmodel.SplashViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(

    viewModel: SplashViewModel = hiltViewModel(),
//    onNavigateToHome: () -> Unit,
    onNavigateToOnboarding: () -> Unit
) {
    val context = LocalContext.current
    val isOnboardingCompleted = viewModel.isFirstTime.collectAsState().value
    LaunchedEffect(isOnboardingCompleted) {
        delay(1500)
        if (isOnboardingCompleted) {
            Toast.makeText(context, "رفتن به صفحه Home", Toast.LENGTH_SHORT).show()
        } else {
            onNavigateToOnboarding()
//            Toast.makeText(context, "رفتن به صفحه Login", Toast.LENGTH_SHORT).show()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painterResource(id = R.drawable.app_logo),
                contentDescription = "",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.feature_splash_app),
                style = typography.headlineMedium,
                color = colorScheme.primary
            )

        }
    }


}