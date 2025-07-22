package ir.aratsoft.todomanager.feature.onboarding.presentation.ui.component

import android.R.attr.onClick
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults.ContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.aratsoft.todomanager.core.designsystem.component.NiaBackground
import ir.aratsoft.todomanager.core.designsystem.theme.AppTheme

@Composable
fun AppSegmentedButton(modifier: Modifier = Modifier,
                       onLangChange: (String) -> Unit,
                       appLang: String) {
    val options = listOf("en", "fa")
    var selectedIndex by remember { mutableIntStateOf(0) }
    LaunchedEffect(appLang) {
        selectedIndex = options.indexOf(appLang).coerceAtLeast(0)
    }
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.wrapContentSize(),
//        space = 8.dp
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
//                modifier = Modifier.wrapContentSize(),
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = {(onLangChange(options[index]))
                    selectedIndex = index },
                selected = index == selectedIndex ,
                icon = { },
                label = {
                    Text(
                        style = MaterialTheme.typography.labelSmall,
                        text = label
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun ViewTogglePreviewCompact() {
    AppTheme(selectedLanguage = "en") {
        NiaBackground {

//            AppSegmentedButton()

        }
    }
}