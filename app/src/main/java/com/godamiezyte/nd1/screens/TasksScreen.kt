package com.godamiezyte.nd1.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godamiezyte.nd1.R
import com.godamiezyte.nd1.Task
import com.godamiezyte.nd1.TopAppBarComposable
import com.godamiezyte.nd1.ui.theme.Cream
import com.godamiezyte.nd1.ui.theme.accent
import com.godamiezyte.nd1.ui.theme.primary
import com.godamiezyte.nd1.ui.theme.secondary

@Composable
fun TasksScreen(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    tasks: List<Task>
) {

    val configuration = LocalConfiguration.current

    val isLandscape =
        configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {

        TasksBody(
            onHomeClick = onHomeClick,
            onAuthorClick = onAuthorClick,
            onAddTasksClick = onAddTasksClick,
            tasks = tasks,
            modifier = Modifier
                .padding(horizontal = 52.dp)
        )

    } else {
        TasksBody(
            onHomeClick = onHomeClick,
            onAuthorClick = onAuthorClick,
            onAddTasksClick = onAddTasksClick,
            tasks = tasks,
            modifier = Modifier
        )
    }
}

@Composable
fun TasksBody(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    tasks: List<Task>,
    modifier: Modifier = Modifier
){
    var searchText by rememberSaveable  { mutableStateOf("") }
    val filteredTasks = tasks.filter { task ->
        task.name.contains(searchText, ignoreCase = true)
    }

    var expandedTask by rememberSaveable  { mutableStateOf<String?>(null) }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBarComposable(
            appName = stringResource(R.string.task_app_name),
            onAuthorClick = onAuthorClick,
            onHomeClick = onHomeClick
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            TaskSearchBar(
                searchText = searchText,
                onSearchTextChange = { searchText = it },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                tasks = filteredTasks,
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(filteredTasks) { task ->

                    val isExpanded = expandedTask == task.name

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Cream,
                                shape = RoundedCornerShape(14.dp)
                            )
                            .animateContentSize()
                            .clickable {
                                expandedTask =
                                    if (isExpanded) null else task.name
                            }
                            .padding(14.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = task.name,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = primary
                                )

                                Text(
                                    text = task.dateTime,
                                    fontSize = 13.sp,
                                    color = secondary,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }

                            if (task.important) {
                                Box(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .background(
                                            color = accent,
                                            shape = CircleShape
                                        )
                                )
                            }
                        }

                        if (isExpanded) {
                            Text(
                                text = task.bio,
                                fontSize = 14.sp,
                                color = secondary,
                                modifier = Modifier.padding(top = 12.dp)
                            )
                        }
                    }
                }
            }
            val localConfig = LocalConfiguration.current.orientation
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom =
                            if (localConfig ==
                                Configuration.ORIENTATION_LANDSCAPE
                            ) 8.dp else 62.dp
                    )
            ) {
                Button(
                    onClick = onAddTasksClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = accent,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "+ Add task",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
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
    var expanded by rememberSaveable  { mutableStateOf(false) }

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
                placeholder = {
                    Text(
                        text = "Search tasks",
                        color = secondary
                    )
                }
            )
        },
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        LazyColumn {
            items(tasks) { task ->
                Text(
                    text = task.name,
                    color = primary,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TasksScreenPreview1() {
    TasksScreen(
        onHomeClick = {},
        onAddTasksClick = {},
        onAuthorClick = {},
        tasks = listOf(
            Task(
                name = "Test task",
                dateTime = "Today",
                bio = "Test description",
                important = true
            )
        )
    )
}

@Preview(
    showBackground = true,
    widthDp = 800,
    heightDp = 400
)
@Composable
fun TasksScreenPreview() {
    TasksScreen(
        onHomeClick = {},
        onAddTasksClick = {},
        onAuthorClick = {},
        tasks = listOf(
            Task(
                name = "Test task",
                dateTime = "Today",
                bio = "Test description",
                important = true
            )
        )
    )
}