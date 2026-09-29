package com.godamiezyte.nd1

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.godamiezyte.nd1.screens.AddTasksScreen
import com.godamiezyte.nd1.screens.AuthorScreen
import com.godamiezyte.nd1.screens.HomeScreen
import com.godamiezyte.nd1.screens.TasksScreen
import com.godamiezyte.nd1.screens.TasksStatisticsScreen

@Composable
fun AppController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
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
                    navController.navigate("settings")
                }
            )
        }

        composable("tasks") {
            TasksScreen(
                onHomeClick = {
                    navController.navigate("home")
                },
                onAddTasksClick ={
                    navController.navigate("add_tasks")
                }

            )
        }

        composable("add_tasks") {
            AddTasksScreen(
                onHomeClick = {
                    navController.navigate("home")
                }
            )
        }
        composable("tasks_statistics") {
            TasksStatisticsScreen(
                onHomeClick = {
                    navController.navigate("home")
                }
            )
        }
        composable("settings"){
            AuthorScreen(
                onHomeClick = {
                    navController.navigate("home")
                },
                author = stringResource(R.string.autor_name),
                group = stringResource(R.string.author_group)
            )
        }
    }
}