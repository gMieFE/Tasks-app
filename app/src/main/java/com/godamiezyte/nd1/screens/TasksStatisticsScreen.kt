package com.godamiezyte.nd1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.godamiezyte.nd1.TopAppBarComposable

@Composable
fun TasksStatisticsScreen(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tasks Statistics")

        TopAppBarComposable(
            appName = "StudyFlow",
            onAuthorClick = onAuthorClick,
            onHomeClick = onHomeClick
        )
    }
}