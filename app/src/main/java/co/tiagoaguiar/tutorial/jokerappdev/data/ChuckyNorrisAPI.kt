package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckyNorrisAPI {
    @GET("jokes/categories")
    fun getCategories(@Query("apiKey") apiKey: String = HTTPClient.API_KEY): Call<List<String>>

    @GET("jokes/random")
    fun getJoke(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = HTTPClient.API_KEY
    ): Call<Joke>
}