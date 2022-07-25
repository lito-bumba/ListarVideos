package com.example.listarvideos.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.listarvideos.data.Video
import com.example.listarvideos.ui.theme.ListarVideosTheme

@Composable
fun ItemVideo(
    video: Video?,
    click: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(0.dp),
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { click() },
        backgroundColor = Color.Black
    ) {
        Column {
            AsyncImage(
                model = video?.imagemUrl,
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            )
            Column {
                Text(
                    text = video?.titulo ?: "",
                    color = Color.White,
                    fontSize = 19.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = video?.autor ?: "",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Preview
@Composable
fun VerItemVideo() {
    ListarVideosTheme {
        ItemVideo(
            Video(
                "Titulo do Video",
                "Autor do Video",
                "",
                ""
            )
        ) { }
    }
}
