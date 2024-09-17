package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper
import android.util.Log


class CategoryRemoteDataSource {
    fun getCategories(callback: ListCategoryCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1"
            )


            //aqui a lista já está pronta
            callback.onSuccess(response)
////            onError(("FALHA NA CONEXÇAO. TENTA NOVAMENTE!!!"))
            callback.onComplete()
        }, 2000)
    }
}


//usaremos interface para chamar a onsuccess e oncomplete do presenter