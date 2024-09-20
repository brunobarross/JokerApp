package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryRemoteDataSource {
    fun getCategories(callback: ListCategoryCallback) {
        HTTPClient.retrofit()
            .create(ChuckyNorrisAPI::class.java)
            .getCategories()
            .enqueue(object : Callback<List<String>>{
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if(response.isSuccessful){
                        val categories = response.body() // aqui tem a lista de categorias
                        callback.onSuccess(categories ?: emptyList())
                    } else{
                        // quando o servidor devolve status de error < 500
                        val error = response.errorBody()?.string() // mensagem de erro
                        callback.onError(error ?: "Erro desconhecido")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                }


            })//assincrona
    }
}


//usaremos interface para chamar a onsuccess e oncomplete do presenter