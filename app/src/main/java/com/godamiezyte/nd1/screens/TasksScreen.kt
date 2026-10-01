package com.godamiezyte.nd1.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
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
import com.godamiezyte.nd1.ui.theme.LightBrown

@Composable
fun TasksScreen(
    onHomeClick: () -> Unit,
    onAuthorClick:() -> Unit,
    onAddTasksClick: () -> Unit,
    tasks: List<Task>
) {

    var searchText by remember { mutableStateOf("") }

    val filteredTasks = tasks.filter { task ->
        task.name.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBrown)
    ) {

        TopAppBarComposable(
            appName = stringResource(R.string.task_app_name),
            onAuthorClick = onAuthorClick,
            onHomeClick = onHomeClick
        )

        TaskSearchBar(
            searchText = searchText,
            onSearchTextChange = { searchText = it },
            modifier = Modifier.padding(16.dp),
            tasks = filteredTasks,
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(vertical = 32.dp, horizontal = 16.dp)
        ) {
            items(filteredTasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF8EBDD))
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.name
                    )

                    Spacer(
                        modifier = Modifier.width(32.dp)
                    )

                    Text(
                        text = task.dateTime
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    if (task.important) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(
                                    Color.Red,
                                    CircleShape
                                )
                        )
                    }
                }
            }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskSearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    tasks: List<Task>,
) {
    var expanded by remember { mutableStateOf(false) }

    BackHandler(enabled = expanded) {
        expanded = false
    }

    SearchBar(
        modifier = modifier,
        inputField = {
            SearchBarDefaults.InputField(
                query = searchText,
                onQueryChange = onSearchTextChange,
                onSearch = { expanded = false },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                placeholder = { Text("Search tasks") }
            )
        },
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        LazyColumn {
            items(tasks) { task ->
                Text(
                    text = task.name,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TasksScreenPreview() {
    TasksScreen(
        onHomeClick = {},
        onAddTasksClick = {},
        onAuthorClick = {},
        tasks = emptyList()
    )
}
