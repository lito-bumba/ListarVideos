package com.example.listarvideos.data

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("title") var titulo: String,
    @SerializedName("author") var autor: String,
    @SerializedName("thumbnailUrl") var imagemUrl: String,
    var link: String
)