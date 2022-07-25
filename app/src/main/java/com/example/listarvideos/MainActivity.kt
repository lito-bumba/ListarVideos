package com.example.listarvideos

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.listarvideos.data.Video
import com.example.listarvideos.ui.ItemVideo
import com.example.listarvideos.ui.theme.ListarVideosTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListarVideosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val estado = viewModel.estado.value

                    Videos(estado.videos)

                    if (estado.erro.isNotBlank())
                        TelaErro(mensagem = estado.erro)
                }
            }
        }
    }

}

private fun openLink(context: Context, link: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(context, browserIntent, null)
}

@Composable
private fun Videos(
    videos: List<Video>
) {
    val context = LocalContext.current
    Column {
        LazyColumn {
            items(videos) {
                ItemVideo(it) { openLink(context, it.link) }
            }
        }
    }
}

@Composable
private fun TelaErro(mensagem: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            imageVector = Icons.Default.Warning,
            contentDescription = "Erro",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = mensagem,
            fontSize = 14.sp,
            color = Color.Red,
            modifier = Modifier.fillMaxWidth(.8f)
        )
    }
}