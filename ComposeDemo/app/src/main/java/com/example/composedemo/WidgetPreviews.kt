package com.example.composedemo

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import java.util.*

@Preview
@Composable
fun CategoryItemPreview() {
    MaterialTheme {
        CategoryItem()
    }
}

@Preview
@Composable
fun MemberItemPreview() {
    MaterialTheme {
        MemberItem()
    }
}

@Preview
@Composable
fun TakePictureSheetPreview() {
    MaterialTheme {
        TakePictureSheet()
    }
}

@Preview
@Composable
fun MoreMenuPreview() {
    MaterialTheme {
        MoreMenu()
    }
}

@Preview
@Composable
fun CategoryListItemPreview() {
    MaterialTheme {
        VerticalScroller {
            Column(modifier = Spacing(8.dp)) {
                for (i in 0..10) {
                    CategoryItem()
                    HeightSpacer(height = 8.dp)
                }
            }
        }
    }
}

@Preview("Member List")
@Composable
fun MemberListItemPreview() {
    MaterialTheme {
        VerticalScroller {
            Column(modifier = Spacing(8.dp)) {
                for (i in 0..10) {
                    MemberItem()
                    HeightSpacer(height = 8.dp)
                }
            }
        }
    }
}