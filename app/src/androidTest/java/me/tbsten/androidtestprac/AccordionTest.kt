package me.tbsten.androidtestprac

import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class AccordionTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `summaryをクリックするとアコーディオンが開く`() {
        // Start the app
        val summaryText = "accordion summary"
        val contentText = "accordion content"
        composeTestRule.setContent {
            Accordion(
                summary = {
                    Text(summaryText)
                }
            ) {
                Text(contentText)
            }
        }

        composeTestRule
            .onNodeWithText(summaryText)    // テキストとして summaryText を持つノードを探し出して
            .performClick()                 // クリックする
        composeTestRule
            .onNodeWithText(contentText)    // テキストとして summaryText を持つノードを探し出して
            .assertIsDisplayed()            // 表示されていることを確認する
    }
}