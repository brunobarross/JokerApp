package co.tiagoaguiar.tutorial.jokerappdev.data

class JokeRemoteDataSource {
    fun getJokes(callback: ListJokeCallback) {
        HTTPClient.retrofit()
            .create(ChuckyNorrisAPI::class.java)
            .getJoke("dev")



    }
}