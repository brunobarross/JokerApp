package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.util.Log
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListJokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : ListJokeCallback {
    fun findJoke(){
        dataSource.getJokes(this)
    }
    override fun onSuccess(response: Joke) {
        Log.d("sucesso", response.toString())
    }

    override fun onError(response: String) {
        Log.e("erro", response)
    }

    override fun onComplete() {
        println("Completou")
    }

}