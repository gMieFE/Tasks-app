package com.godamiezyte.nd1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.godamiezyte.nd1.R
import com.godamiezyte.nd1.Task
import com.godamiezyte.nd1.TopAppBarComposable
import com.godamiezyte.nd1.ui.theme.Brown
import com.godamiezyte.nd1.ui.theme.LightBrown

@Composable
fun AddTasksScreen(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit,
    onTaskAdded: (Task) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBrown),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopAppBarComposable(
            appName = stringResource(R.string.task_app_name),
            onAuthorClick = onAuthorClick,
            onHomeClick = onHomeClick
        )

        Column(
            modifier = Modifier
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var taskName by remember { mutableStateOf("") }
            var dateTime by remember { mutableStateOf("") }
            var bio by remember { mutableStateOf("") }
            var important by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = taskName,
                onValueChange = { taskName = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                label = { Text("Task name") }
            )

            OutlinedTextField(
                value = dateTime,
                onValueChange = { dateTime = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                label = { Text("Date and time")}
            )

            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                label = { Text("Extra details")}
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = important,
                    onCheckedChange = { important = it }
                )

                Text("Important")
            }

            ElevatedButton(
                onClick = {
                    val task = Task(
                        name = taskName,
                        dateTime = dateTime,
                        bio = bio,
                        important = important
                    )

                    onTaskAdded(task)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Brown,
                    contentColor = Color.White
                )
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
        onAuthorClick = {},
        onTaskAdded = {}
    )
}