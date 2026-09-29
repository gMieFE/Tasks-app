package com.godamiezyte.nd1.screens

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

@Composable
fun AuthorScreen(
    onHomeClick: () -> Unit,
    author: String,
    group: String
) {
    Column(
        modifier =  Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Button(
                onClick = onHomeClick
            ) {
                Text("Home")
            }
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = author
            )

            Text(
                text = group
            )
        }
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