package me.tbsten.androidtestprac

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun Accordion(
    summary: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    var openAccordion by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(1.dp, Color.Black)
    ) {
        // summary
        CompositionLocalProvider(
            LocalTextStyle provides TextStyle.Default.copy(color = Color.White)
        ) {
            Box(Modifier
                .fillMaxWidth()
                .clickable { openAccordion = !openAccordion }
                .background(Color.Red)
                .padding(12.dp)
            ) {
                summary()
            }
        }
        // content
        Log.d("accordion", "open:$openAccordion")
        if (openAccordion) {
            Box(Modifier.padding(4.dp)) {
                content()
            }
        }
    }
}
