package com.godamiezyte.nd1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    onAuthorClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    onTasksClick: () -> Unit,
    onTasksStatisticsClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBarComposable(
            appName = "StudyFlow",
            onAuthorClick = onAuthorClick
        )

        HomeBody(
            onTasksClick = onTasksClick,
            onTasksStatisticsClick = onTasksStatisticsClick,
            onAddTasksClick = onAddTasksClick,
            modifier = Modifier.weight(1f)
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)  //??
@Composable
fun TopAppBarComposable(
    onAuthorClick: () -> Unit,
    appName: String,
) {
    var expanded by remember { mutableStateOf(false) }
//paklausti ar turi isokti naujas lankgas ar alertas (AlertDialog)
  TopAppBar(
        title = {
            Text(appName)
        },
        actions = {
            Box(
                modifier = Modifier.padding(32.dp)
            ) {
                Text(
                    text = "⋮",
                    modifier = Modifier.clickable {
                        expanded = true
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    DropdownMenuItem(
                        text = { Text("Author") },
                        onClick = {
                            expanded = false
                            onAuthorClick()
                        }
                    )
                }
            }
        },
      colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFF6750A4)
      )
    )
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
            .background(Color(0xFFE8DEF8))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = "Main task"
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
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

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onTasksClick = {},
        onAddTasksClick = {},
        onTasksStatisticsClick = {},
        onAuthorClick = {},
    )
}