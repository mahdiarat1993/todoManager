package ir.aratsoft.todomanager.feature.onboarding.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ir.aratsoft.todomanager.feature.onboarding.presentation.viewmodel.OnboardingViewModel
import ir.aratsoft.todomanager.feature.onboarding.presentation.event.OnboardingEvent
import ir.aratsoft.todomanager.feature.onboarding.presentation.ui.component.AppSegmentedButton
import ir.aratsoft.todomanager.feature.onboarding.presentation.ui.component.OnboardingPager
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import ir.aratsoft.todomanager.feature.onboarding.presentation.ui.component.BottomSheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val currentLang by viewModel.selectedLang.collectAsState()
    val scope = rememberCoroutineScope()
//    val scaffoldState = rememberBottomSheetScaffoldState()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false
        )
    )
    val sheetVisible by remember {
        derivedStateOf {
            scaffoldState.bottomSheetState.targetValue != SheetValue.Expanded
        }
    }

    var dragable: Boolean = true


    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) {
//                        viewModel.onEvent(OnboardingEvent.DisMissModal)
                        scope.launch { scaffoldState.bottomSheetState.hide() }
                            .invokeOnCompletion { dragable = dragable.not() }
                    }
                })
            }
    ) {
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                BottomSheetContent()
            },
            sheetPeekHeight = 0.dp
        ) {
            Scaffold(
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .background(MaterialTheme.colorScheme.background)

                    ) {
                        Column(
                            Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                AppSegmentedButton(onLangChange = {
                                    viewModel.onEvent(
                                        OnboardingEvent.OnLangChange(
                                            it
                                        )
                                    )
                                }, appLang = currentLang)
                            }
                            OnboardingPager(
                                scope = scope,
                                items = uiState.onboardingPagerData,
                                onStart = {
                                    scope.launch { scaffoldState.bottomSheetState.expand() }
                                        .invokeOnCompletion { dragable = dragable.not() }
                                },
                                isScrollable = (scaffoldState.bottomSheetState.currentValue != SheetValue.Expanded)
                            )

                        }
                    }

                    if(!sheetVisible){
                        Box(modifier = Modifier.fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.3f)))
                    }

                }
            )
        }
    }
}
