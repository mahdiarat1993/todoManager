package ir.aratsoft.todomanager.feature.onboarding.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.DrawerDefaults.scrimColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ir.aratsoft.todomanager.core.designsystem.component.AppButton
import ir.aratsoft.todomanager.feature.onboarding.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBottomSheet(
    sheetState: SheetState,
    onGuestClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        contentWindowInsets = { BottomSheetDefaults.windowInsets },
        scrimColor = Color.Transparent,
    ) {
        BottomSheetContent()
    }
}

@Composable
fun BottomSheetContent(){
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.feature_onboarding_sign_in),
            style = typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.feature_onboarding_for_enter_login_or_sign_in),
            style = typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            modifier = Modifier.fillMaxWidth(),
            textColor = MaterialTheme.colorScheme.primary,
            buttonColor = MaterialTheme.colorScheme.onPrimary,
            text = { Text(text = stringResource(R.string.feature_onboarding_login_as_guest)) },
            onClick = { })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            modifier = Modifier.fillMaxWidth(),
            textColor = MaterialTheme.colorScheme.primary,
            buttonColor = MaterialTheme.colorScheme.onPrimary,
            text = { Text(text = stringResource(R.string.feature_onboarding_sign_in_whith_google)) },
            onClick = { })

        Spacer(modifier = Modifier.height(16.dp))


    }
}