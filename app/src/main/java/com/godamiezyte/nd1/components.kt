package com.godamiezyte.nd1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)  //??
@Composable
fun TopAppBarComposable(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit,
    appName: String,
) {
    var expanded by remember { mutableStateOf(false) }
//paklausti ar turi isokti naujas lankgas ar alertas (AlertDialog)
    TopAppBar(
        title = {
            Text(
                text = appName,
                modifier = Modifier.clickable {
                    onHomeClick()
                }
            )
        },
        actions = {
            Box(
                modifier = Modifier.padding(32.dp)
            ) {
                Text(
                    text = "⋮",
                    modifier = Modifier.clickable {
                        expanded = true
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    DropdownMenuItem(
                        text = { Text("Author") },
                        onClick = {
                            expanded = false
                            onAuthorClick()
                        }
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF6750A4)
        )
    )
}

@Composable
fun AuthorDialog(
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(stringResource(R.string.author_name))
        },
        text = {
            Text(
                stringResource(R.string.author_group)
            )
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Gerai")
            }
        }
    )
}