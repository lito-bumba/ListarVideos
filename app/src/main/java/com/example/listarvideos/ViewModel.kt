package com.example.listarvideos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.listarvideos.data.Api
import com.example.listarvideos.data.Video
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {

    private val _estado = mutableStateOf(Estado())
    val estado: State<Estado> = _estado

    private val api = Api.getInstance()
    private val request by lazy {
        api.pegarTodosVideos()
    }


    init {
        pegarTodosVideos()
    }

    private fun pegarTodosVideos() {

        request.enqueue(object : Callback<List<Video>> {
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                _estado.value = Estado(videos = response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
                _estado.value = Estado(erro = t.message ?: "")
            }
        })

    }
}

data class Estado(
    val videos: List<Video> = emptyList(),
    val erro: String = ""
)