package ir.aratsoft.todomanager.feature.onboarding.presentation.ui.component

import android.R.attr.onClick
import android.R.attr.text
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.aratsoft.todomanager.core.designsystem.component.AppButton
import ir.aratsoft.todomanager.core.designsystem.component.AppButtonCircular
import ir.aratsoft.todomanager.core.designsystem.component.AppButtonCircularOutlined
import ir.aratsoft.todomanager.core.designsystem.component.AppTextButton
import ir.aratsoft.todomanager.core.designsystem.icon.AppIcons
import ir.aratsoft.todomanager.feature.onboarding.domain.model.OnboardingData
import ir.aratsoft.todomanager.feature.onboarding.R
import ir.aratsoft.todomanager.feature.onboarding.presentation.event.OnboardingEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun OnboardingPager(
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    items: List<OnboardingData> = emptyList(),
    onStart: () -> Unit,
    isScrollable: Boolean = true
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        items.size
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            state = pagerState,
            Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            userScrollEnabled = isScrollable
        ) { currentPage ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(26.dp),
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(items[currentPage].imageRes))
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .size(300.dp)
                        .align(Alignment.TopCenter)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(items[currentPage].title),
                        textAlign = TextAlign.Center,
                        style = typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = stringResource(items[currentPage].desc),
                        textAlign = TextAlign.Center,
                        style = typography.bodyLarge
                    )
                }

            }
        }

        PageIndicator(
            pageCount = items.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .padding(45.dp)
                .align(Alignment.BottomCenter)
        )

        ButtonsSection(
            pagerState = pagerState,
            onStart = onStart
//        navController = navController,
//        context = context
        )
    }
//    if (isModalShow) {
//        LoginBottomSheet(
//            onGuestClick = { /* ورود مهمان */ },
//            onGoogleSignInClick = { /* ورود جیمیل */ },
//            onDismissRequest = { onDisMissModal() }
//        )
//    }

}

@Composable
fun ButtonsSection(
    pagerState: PagerState,
    onStart: () -> Unit
) {

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {

        if (pagerState.currentPage != 0) {
            AppButtonCircularOutlined(
                onClick = {
                    scope.launch {
                        val prevPage = pagerState.currentPage - 1
                        if (prevPage >= 0) {
                            pagerState.animateScrollToPage(prevPage)
                        }
                    }
                },
                icon = AppIcons.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )
        }
        if (pagerState.currentPage != 2) {

            AppButtonCircular(
                onClick = {
                    scope.launch {
                        val nextPage = pagerState.currentPage + 1
                        pagerState.animateScrollToPage(nextPage)
                    }
                },
                icon = AppIcons.ArrowForward,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )


        } else {

            AppButton(
                text = { Text(text = stringResource(R.string.feature_onboarding_start))},
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = { onStart() })

        }
    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorSingleDot(isSelected = it == currentPage)
        }


    }
}

@Composable
fun IndicatorSingleDot(isSelected: Boolean) {

    val width = animateDpAsState(targetValue = if (isSelected) 35.dp else 15.dp, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(15.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

//private fun onBoardingIsFinished(context: MainActivity) {
//    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
//    val editor = sharedPreferences.edit()
//    editor.putBoolean("isFinished", true)
//    editor.apply()
//
//}