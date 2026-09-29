package com.godamiezyte.nd1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    onSettingsClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    onTasksClick: () -> Unit,
    onTasksStatisticsClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        TopAppBar(
            appName = "StudyFlow",
            onSettingsClick = onSettingsClick
        )

        HomeBody(
            onTasksClick = onTasksClick,
            onTasksStatisticsClick = onTasksStatisticsClick,
            onAddTasksClick = onAddTasksClick,
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
fun TopAppBar(
    onSettingsClick: () -> Unit,
    appName: String,
    modifier: Modifier = Modifier
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF6750A4))
            .padding(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = appName,
            color = Color.White
        )

        Text(
            text = ":",
            color = Color.White,
            modifier = Modifier
                .clickable {
                    onSettingsClick()
                }
        )
    }
}

@Composable
fun HomeBody(
    onTasksClick: () -> Unit,
    onTasksStatisticsClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFE8DEF8))
        ) {
            Text(
                text = "Main task"
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color(0xFFE8DEF8))
        ) {
            Button(
                onClick = onTasksStatisticsClick
            ) {
                Text("Statistics")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color(0xFFE8DEF8))
        ) {
            Button(
                onClick = onTasksClick
            ) {
                Text("Tasks")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFE8DEF8))
        ) {
            Button(
                onClick = onAddTasksClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("+")
            }
        }
    }
}