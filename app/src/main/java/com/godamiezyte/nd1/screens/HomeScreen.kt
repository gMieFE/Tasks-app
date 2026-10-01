package com.godamiezyte.nd1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.godamiezyte.nd1.R
import com.godamiezyte.nd1.TopAppBarComposable
import com.godamiezyte.nd1.ui.theme.LightBrown


@Composable
fun HomeScreen(
    onAuthorClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    onTasksClick: () -> Unit,
    onTasksStatisticsClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBarComposable(
            appName = stringResource(R.string.task_app_name),
            onAuthorClick = onAuthorClick,
            onHomeClick = onHomeClick
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
fun HomeBody(
    onTasksClick: () -> Unit,
    onTasksStatisticsClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(LightBrown)
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


//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(2f)
//        ) {
//            Button(
//                onClick = onTasksStatisticsClick
//            ) {
//                Text("Statistics")
//            }
//        }

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
        onHomeClick = {}
    )
}