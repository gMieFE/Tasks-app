package com.godamiezyte.nd1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.godamiezyte.nd1.TopAppBarComposable

@Composable
fun AddTasksScreen(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopAppBarComposable(
            appName = "StudyFlow",
            onAuthorClick = onAuthorClick,
            onHomeClick = onHomeClick
        )

        Column(
        ) {
            var taskName by remember { mutableStateOf("") }
            var dateTime by remember { mutableStateOf("") }
            var bio by remember { mutableStateOf("") }
            var important by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = taskName,
                onValueChange = { taskName = it },
                label = { Text("Task name") }
            )

            OutlinedTextField(
                value = dateTime,
                onValueChange = { dateTime = it },
                label = { Text("Date and time")}
            )

            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text("Extra details")}
            )

            Row {
                Checkbox(
                    checked = important,
                    onCheckedChange = { important = it }
                )

                Text("Important")
            }

            Button(
                onClick = onHomeClick
            ) {
                Text("ADD")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTasksScreenPreview() {
    AddTasksScreen(
        onHomeClick = {},
        onAuthorClick = {}
    )
}