package com.godamiezyte.nd1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            // Changed: slightly taller app bar to fit the new HomeScreen design.
            .height(68.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.cat_collage),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            // Kept: the collage still fills the entire top bar.
            contentScale = ContentScale.Crop
        )

        // Changed: softer dark overlay so the cats remain visible
        // while the white text is still easy to read.
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
                    // Changed: warm off-white instead of pure white
                    // to fit the softer colour palette.
                    color = Color(0xFFFFFCF8),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        onHomeClick()
                    }
                )
            },

            actions = {
                Box(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Text(
                        text = "⋮",
                        // Changed: slightly smaller menu icon.
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFCF8),
                        modifier = Modifier.clickable {
                            expanded = true
                        }
                    )

                    // Kept: existing dropdown functionality.
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        // Changed: menu item styling to fit the new theme.
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

            // Changed: transparent app bar so the collage stays visible.
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