package com.example.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.border.DrawBorder
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.EditorStyle
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory {
                Toast.makeText(this,"Clicked!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

@Composable
fun Input(value: String) {
    val state = +state { "" }
    state.value = value
    Container(expanded = true, height = 32.dp, padding = EdgeInsets(5.dp)) {
        DrawBorder(shape = RoundedCornerShape(5.dp), border = Border(color = Color.Blue, width = 0.5.dp))
        TextField(
            value = state.value,
            onValueChange = { state.value = it },
            editorStyle = EditorStyle(
                textStyle = TextStyle(
                    color = Color.Blue
                )
            )
        )
    }
}

@Composable
fun NewStory(onClick: () -> Unit) {
    val image = +imageResource(R.drawable.poster)
    MaterialTheme {
        Column(crossAxisSize = LayoutSize.Expand, modifier = Spacing(16.dp)) {
            Button(style = ButtonStyle(
                shape = RectangleShape,
                elevation = 0.dp,
                color = Color.Transparent,
                paddings = EdgeInsets(0.dp)
            ), onClick = onClick) {
                Container(expanded = true, height = 180.dp) {
                    Clip(shape = RoundedCornerShape(8.dp)) {
                        DrawImage(image = image)
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
            HeightSpacer(height = 8.dp)
            Input(value = "TawWin Garden Hotel")
            HeightSpacer(height = 8.dp)
            Button(style = OutlinedButtonStyle(), onClick = onClick) {
                Container(expanded = true) {
                    Text(text = "Click Me!" , style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ))
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewStory(onClick = {})
}
