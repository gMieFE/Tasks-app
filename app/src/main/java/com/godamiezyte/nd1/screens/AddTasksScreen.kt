package com.godamiezyte.nd1.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godamiezyte.nd1.R
import com.godamiezyte.nd1.Task
import com.godamiezyte.nd1.TopAppBarComposable
import com.godamiezyte.nd1.ui.theme.Cream
import com.godamiezyte.nd1.ui.theme.LightBeige
import com.godamiezyte.nd1.ui.theme.accent
import com.godamiezyte.nd1.ui.theme.background
import com.godamiezyte.nd1.ui.theme.primary
import com.godamiezyte.nd1.ui.theme.secondary

@Composable
fun AddTasksScreen(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit,
    onTaskAdded: (Task) -> Unit
) {


    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    if (isLandscape) {

        AddTasksPortrait(
            onHomeClick = onHomeClick,
            onAuthorClick = onAuthorClick,
            onTaskAdded = onTaskAdded,
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 52.dp
                )
                .verticalScroll(rememberScrollState())
        )

    } else {
        AddTasksPortrait(
            onHomeClick = onHomeClick,
            onAuthorClick = onAuthorClick,
            onTaskAdded = onTaskAdded,
            modifier = Modifier.padding(
                vertical = 28.dp,
                horizontal = 20.dp
            )
        )
    }
}

    @Composable
    fun AddTasksPortrait(
        onHomeClick: () -> Unit,
        onAuthorClick: () -> Unit,
        onTaskAdded: (Task) -> Unit,
        modifier: Modifier = Modifier
    ){
        var taskName by rememberSaveable  { mutableStateOf("") }
        var dateTime by rememberSaveable  { mutableStateOf("") }
        var bio by rememberSaveable  { mutableStateOf("") }
        var important by rememberSaveable  { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TopAppBarComposable(
                appName = stringResource(R.string.task_app_name),
                onAuthorClick = onAuthorClick,
                onHomeClick = onHomeClick
            )

            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Create a task",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Add the details for your new task.",
                    fontSize = 14.sp,
                    color = secondary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )


                OutlinedTextField(
                    value = taskName,
                    onValueChange = { taskName = it },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Cream,
                        focusedContainerColor = Cream,
                        unfocusedBorderColor = LightBeige,
                        focusedBorderColor = accent,
                        focusedTextColor = primary,
                        unfocusedTextColor = primary,
                        focusedLabelColor = accent,
                        unfocusedLabelColor = secondary
                    ),
                    label = {
                        Text("Task name")
                    }
                )


                OutlinedTextField(
                    value = dateTime,
                    onValueChange = { dateTime = it },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Cream,
                        focusedContainerColor = Cream,
                        unfocusedBorderColor = LightBeige,
                        focusedBorderColor = accent,
                        focusedTextColor = primary,
                        unfocusedTextColor = primary,
                        focusedLabelColor = accent,
                        unfocusedLabelColor = secondary
                    ),
                    label = {
                        Text("Date and time")
                    }
                )


                OutlinedTextField(
                    value = bio,
                    onValueChange = { bio = it },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Cream,
                        focusedContainerColor = Cream,
                        unfocusedBorderColor = LightBeige,
                        focusedBorderColor = accent,
                        focusedTextColor = primary,
                        unfocusedTextColor = primary,
                        focusedLabelColor = accent,
                        unfocusedLabelColor = secondary
                    ),
                    label = {
                        Text("Extra details")
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = important,
                        onCheckedChange = { important = it },

                        colors = CheckboxDefaults.colors(
                            checkedColor = accent,
                            uncheckedColor = secondary,
                            checkmarkColor = Color.White
                        )
                    )

                    Text(
                        text = "Important",
                        color = primary,
                        fontWeight = FontWeight.Medium
                    )
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
                        text = "ADD TASK",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }


@Composable
fun TaskForm(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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


@Preview(
    showBackground = true,
    widthDp = 800,
    heightDp = 400
)
@Composable
fun AddTasksScreenPreview1() {
    AddTasksScreen(
        onHomeClick = {},
        onAuthorClick = {},
        onTaskAdded = {}
    )
}