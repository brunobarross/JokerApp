package co.tiagoaguiar.tutorial.jokerappdev.data

import android.util.Log
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class JokeRemoteDataSource {
    fun getJokes(callback: ListJokeCallback, category: String) {
        HTTPClient.retrofit().create(ChuckyNorrisAPI::class.java).getJoke(category)
            .enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if (response.isSuccessful) {
                        val joke = response.body()
                        callback.onSuccess(joke ?: throw RuntimeException("Piada não encontrada"))

                    } else {
                        val error = response.errorBody()?.string()
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                }

            })


    }
}