package com.godamiezyte.nd1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godamiezyte.nd1.ui.theme.WarmWhite
import com.godamiezyte.nd1.ui.theme.accent
import com.godamiezyte.nd1.ui.theme.primary
import com.godamiezyte.nd1.ui.theme.secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(
    onHomeClick: () -> Unit,
    onAuthorClick: () -> Unit,
    appName: String,
) {
    var expanded by rememberSaveable  { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.cat_collage),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.32f))
        )

        TopAppBar(
            modifier = Modifier.fillMaxWidth(),


            title = {
                Text(
                    text = appName,
                    color = WarmWhite,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                )
            },

            navigationIcon = {
                IconButton(
                    onClick = onHomeClick,
                    modifier = Modifier
                        .padding( horizontal = 16.dp)
                        .size(28.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.home_1_svgrepo_com),
                        contentDescription = "Home",
                        tint = WarmWhite
                    )
                }
            },

            actions = {
                Box(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        ,
                ) {
                    Text(
                        text = "⋮",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFCF8),
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
                            text = {
                                Text(
                                    text = "Author",
                                    color = Color(0xFF3E3028),
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            onClick = {
                                expanded = false
                                onAuthorClick()
                            }
                        )
                    }
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
        )
    }
}

@Composable
fun AuthorDialog(
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text(
                text = stringResource(R.string.author_name),
                color = primary,
                fontWeight = FontWeight.Bold
            )
        },

        text = {
            Text(
                text = stringResource(R.string.author_group),
                color = secondary
            )
        },

        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(
                    text = "Ok",
                    color = accent,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}