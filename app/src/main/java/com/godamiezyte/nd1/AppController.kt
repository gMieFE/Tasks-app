package com.godamiezyte.nd1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.godamiezyte.nd1.screens.AddTasksScreen
import com.godamiezyte.nd1.screens.HomeScreen
import com.godamiezyte.nd1.screens.TasksScreen
import com.godamiezyte.nd1.screens.TasksStatisticsScreen

@Composable
fun AppController() {
    val navController = rememberNavController()

    var showAuthorDialog by remember { mutableStateOf(false) }

    var tasks by remember { mutableStateOf(listOf<Task>()) }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onHomeClick = {
                    navController.navigate("home")
                },
                onTasksClick = {
                    navController.navigate("tasks")
                },
                onAddTasksClick = {
                    navController.navigate("add_tasks")
                },
                onTasksStatisticsClick = {
                    navController.navigate("tasks_statistics")
                },
                onAuthorClick = {
                    showAuthorDialog = true
                }
            )
        }

        composable("tasks") {
            TasksScreen(
                onHomeClick = {
                    navController.navigate("home")
                },
                onAddTasksClick = {
                    navController.navigate("add_tasks")
                },
                onAuthorClick = {
                    showAuthorDialog = true
                },
                tasks = tasks
            )
        }

        composable("add_tasks") {
            AddTasksScreen(
                onHomeClick = {
                    navController.navigate("home")
                },
                onAuthorClick = {
                    showAuthorDialog = true
                },
                onTaskAdded = { task ->
                    tasks = tasks + task
                    navController.navigate("tasks")
                }
            )
        }

        composable("tasks_statistics") {
            TasksStatisticsScreen(
                onHomeClick = {
                    navController.navigate("home")
                },
                onAuthorClick = {
                    showAuthorDialog = true
                }
            )
        }
    }

        if (showAuthorDialog) {
            AuthorDialog(
                onDismiss = {
                    showAuthorDialog = false
                },
            )
        }
}