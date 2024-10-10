package co.tiagoaguiar.tutorial.jokerappdev.model

import com.google.gson.annotations.SerializedName

data class Joke(
    val id: String,
    @SerializedName("value") val text: String,
    @SerializedName("icon_url") val icon_url: String,
)
