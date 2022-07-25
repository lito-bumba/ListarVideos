package com.example.listarvideos.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("lista-lives.json")
    fun pegarTodosVideos(): Call<List<Video>>

    companion object {

        private val api: Api by lazy {
            val api = Retrofit.Builder()
                .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            api.create(Api::class.java)
        }

        fun getInstance(): Api = api
    }
}