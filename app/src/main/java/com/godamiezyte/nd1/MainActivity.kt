package com.godamiezyte.nd1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.godamiezyte.nd1.screens.HomeScreen
import com.godamiezyte.nd1.ui.theme.GM_ND1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GM_ND1Theme {
                AppController()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onTasksClick = {},
        onAddTasksClick = {},
        onTasksStatisticsClick = {},
        onAuthorClick = {},
        onHomeClick = {}
    )
}