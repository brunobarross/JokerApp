package co.tiagoaguiar.tutorial.jokerappdev.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckyNorrisAPI {
    @GET("jokes/categories")
    fun getCategories(@Query("apiKey")apiKey: String = HTTPClient.API_KEY) : Call<List<String>>
}