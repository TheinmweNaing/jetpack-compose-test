package com.example.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.border.DrawBorder
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }
}

@Composable
fun Input(value: String) {
    val state = +state { "" }
    state.value = value
    val focused = +state { false }

    Container(expanded = true, height = 32.dp, padding = EdgeInsets(5.dp)) {
        DrawBorder(
            shape = RoundedCornerShape(5.dp),
            border = Border(color = if (focused.value) Color.Blue else Color.DarkGray, width = 1.dp)
        )
        TextField(
            value = state.value,
            onValueChange = { state.value = it },
            editorStyle = EditorStyle(
                textStyle = TextStyle(
                    color = Color.Blue
                )
            ), onFocus = { focused.value = true },
            onBlur = { focused.value = false }
        )
    }
}

@Composable
fun NewStory() {
    val image = +imageResource(R.drawable.poster)
    val context = +ambient(ContextAmbient)
    MaterialTheme {
        Column(crossAxisSize = LayoutSize.Expand, modifier = Spacing(16.dp)) {
            Ripple(bounded = true) {
                Clickable {
                    Container(expanded = true, height = 180.dp) {
                        Clip(shape = RoundedCornerShape(8.dp)) {
                            DrawImage(image = image)
                        }
                    }
                }
            }
            HeightSpacer(height = 16.dp)
            Text(text = "Droid Yangon", style = +themeTextStyle { h6 })
            HeightSpacer(height = 4.dp)
            Text(
                text = "Jul 10, 2019", style = TextStyle(
                    color = Color.Blue,
                    fontStyle = FontStyle.Italic
                )
            )
            HeightSpacer(height = 16.dp)
            Input(value = "TawWin Garden Hotel")
            HeightSpacer(height = 16.dp)
            Input(value = ".............................")
            HeightSpacer(height = 16.dp)
            Button(style = OutlinedButtonStyle(), onClick = {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
            }) {
                Container(expanded = true) {
                    Text(
                        text = "Click Me!", style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewStory()
}
