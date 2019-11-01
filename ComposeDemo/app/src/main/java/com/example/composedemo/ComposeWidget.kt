package com.example.composedemo

import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview

@Composable
fun CategoryItem() {
    Card(
        shape = RoundedCornerShape(5.dp),
        color = Color.White,
        elevation = 0.dp
    ) {
        FlexRow(modifier = Spacing(16.dp)) {
            expanded(1f) {
                Text(
                    text = "Category", style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            inflexible {
                Text(
                    text = "1000", style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun MemberItem() {
    val image = +imageResource(R.drawable.poster)
    Card(
        shape = RoundedCornerShape(5.dp),
        color = Color.White,
        elevation = 0.dp
    ) {
        FlexRow(crossAxisAlignment = CrossAxisAlignment.Center, modifier = Spacing(16.dp)) {
            inflexible {
                Container(width = 40.dp, height = 40.dp) {
                    Clip(shape = CircleShape) {
                        DrawImage(image = image)
                    }
                }
            }
            expanded(1f) {
                Text(
                    text = "Name", style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    ), modifier = Spacing(left = 16.dp, right = 16.dp)
                )
            }
            inflexible {
                Text(
                    text = "1000", style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun TakePictureSheet() {
    Card(
        shape = RoundedCornerShape(
            topLeft = 16.dp,
            topRight = 16.dp
        ),
        color = Color.White,
        elevation = 0.dp
    ) {
        FlexRow(modifier = Spacing(16.dp)) {
            expanded(1f) {
                ImageButton(id = R.drawable.photo_camera, label = "Take Photo")
            }
            inflexible {
                HeightSpacer(height = 16.dp)
            }
            expanded(1f) {
                ImageButton(id = R.drawable.gallery, label = "Choose from Gallery")
            }
        }
    }
}

@Composable
fun MoreMenu() {
    Card(
        shape = RoundedCornerShape(5.dp),
        color = Color.White,
        elevation = 0.dp
    ) {
        Column {
            MoreMenuItem(id = R.drawable.ic_report_chart_dark, label = "Report")
            Divider(color = Color.Gray)
            MoreMenuItem(id = R.drawable.ic_restore_dark, label = "Restore")
            Divider(color = Color.Gray)
            MoreMenuItem(id = R.drawable.ic_backup_dark, label = "Backup")
        }
    }
}

@Composable
private fun ImageButton(@DrawableRes id: Int, label: String) {
    val image = +imageResource(id)
    Ripple(bounded = true) {
        Clickable {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = 0.dp
            ) {
                Column(modifier = Spacing(16.dp), crossAxisAlignment = CrossAxisAlignment.Center) {
                    Container(width = 60.dp, height = 60.dp) {
                        DrawImage(image = image)
                    }
                    HeightSpacer(height = 16.dp)
                    Text(text = label)
                }
            }
        }
    }
}

@Composable
private fun MoreMenuItem(@DrawableRes id: Int, label: String) {
    val vector = +vectorResource(id)
    FlexRow(modifier = Spacing(16.dp)) {
        inflexible {
            WithDensity {
                Container(
                    width = vector.defaultWidth.toDp()
                ) {
                    DrawVector(vectorImage = vector)
                }
            }
        }
        expanded(1f) {
            Text(text = label, modifier = Spacing(left = 16.dp))
        }
    }
}


