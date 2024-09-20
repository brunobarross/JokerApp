package co.tiagoaguiar.tutorial.jokerappdev.data

import retrofit2.Call
import retrofit2.http.GET

interface ChuckyNorrisAPI {
    @GET("jokes/categories")
    fun getCategories() : Call<List<String>>
}