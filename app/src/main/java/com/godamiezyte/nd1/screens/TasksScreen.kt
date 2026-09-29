package com.godamiezyte.nd1.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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

@Composable
fun TasksScreen(
    onHomeClick: () -> Unit,
    onAddTasksClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 16.dp),
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Button(
                onClick = onHomeClick,
                modifier = Modifier
                    .align(Alignment.CenterStart)
            ) {
                Text(
                    text = "Home",
                )
            }

            Text(
                text = "Tasks",
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var searchText by remember { mutableStateOf("") }

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Search tasks") }
            )
        }


        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = "1. Blah blak"
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.End)
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Button(
                onClick = onAddTasksClick,
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text("+")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TasksScreenPreview() {
    TasksScreen(
        onHomeClick = {},
        onAddTasksClick = {}
    )
}
