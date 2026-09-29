package com.godamiezyte.nd1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.godamiezyte.nd1.R

@Composable
fun AuthorScreen(
    onHomeClick: () -> Unit,
    author: String, group: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onHomeClick
        ) {
            Text("Home")
        }

        Text(
            text = author
        )

        Text(
            text = group
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorScreenPreview() {
    AuthorScreen(
        onHomeClick = {},
        author = stringResource(R.string.autor_name),
        group = stringResource(R.string.author_group)
    )
}