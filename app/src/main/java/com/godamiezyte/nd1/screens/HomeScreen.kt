
package com.godamiezyte.nd1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godamiezyte.nd1.R
import com.godamiezyte.nd1.Task
import com.godamiezyte.nd1.TopAppBarComposable
import com.godamiezyte.nd1.ui.theme.accent
import com.godamiezyte.nd1.ui.theme.background
import com.godamiezyte.nd1.ui.theme.primary
import com.godamiezyte.nd1.ui.theme.secondary


@Composable
fun HomeScreen(
    onAuthorClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    onTasksClick: () -> Unit,
    onHomeClick: () -> Unit,
    tasks: List<Task>
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
            onAddTasksClick = onAddTasksClick,
            modifier = Modifier.weight(1f),
            tasks = tasks
        )
    }
}


@Composable
fun HomeBody(
    onTasksClick: () -> Unit,
    onAddTasksClick: () -> Unit,
    modifier: Modifier = Modifier,
    tasks: List<Task>
) {


    Column(
        modifier = modifier
            .background(background)
            .padding(20.dp)
    ) {

        // Header
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Your tasks",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Here are the things that need your attention.",
                fontSize = 14.sp,
                color = secondary,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Important tasks",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = primary,
                modifier = Modifier.padding(end = 16.dp)
            )

            Box(
                modifier = Modifier
                    .background(
                        accent,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "${tasks.count { it.important }}",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.Top
        ) {

            val importantTasks = tasks.filter { it.important }


                importantTasks.forEach { task ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .width(5.dp)
                                    .height(40.dp)
                                    .background(
                                        accent,
                                        RoundedCornerShape(10.dp)
                                    )
                                    .padding(bottom = 8.dp)
                            )


                            Text(
                                text = task.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = primary
                            )
                            Text(
                                text = task.dateTime,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = primary
                            )
                        }
                    }
                }
        }


        Column (
            modifier = Modifier.padding(bottom = 32.dp)
        ){
            Button(
                onClick = onTasksClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .padding(bottom = 8.dp),
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primary
                )
            ) {
                Text(
                    text = "View all tasks",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }


            Button(
                onClick = onAddTasksClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .padding(bottom = 8.dp),
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = accent
                )
            ) {
                Text(
                    text = "+  Add task",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onTasksClick = {},
        onAddTasksClick = {},
        onAuthorClick = {},
        onHomeClick = {},
        tasks = emptyList()
    )
}

