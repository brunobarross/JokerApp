package co.tiagoaguiar.tutorial.jokerappdev.data

import android.view.View
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment

interface ListJokeCallback {
    fun onSuccess(response: Joke)
    fun onError(response: String)
    fun onComplete()
}