package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    // VIEW <- PRESENTER
    // PRESENTER -> VIEW
    fun findAllCategory() {
        view.showProgress()
        fakeRequest()

    }

    fun onComplete() {
        view.hideProgress()
    }

    fun onSuccess(response: List<String>) {
        val categories = response.map { category -> Category(category, 0xFFFF0000) }
        view.showCategories(categories)
    }

    fun onError(message: String) {
        view.showFailure(message)

    }

    //simula requisição HTTP
    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1"
            )
            //aqui a lista já está pronta
            onSuccess(response)
//            onError(("FALHA NA CONEXÇAO. TENTA NOVAMENTE!!!"))
            onComplete()
        }, 2000)
    }

}


// 1, CICLO DE VIDA DO FRAGMENT FAZ A AÇÃO (CHAMAR O PRESENTER PARA BUSCAR AS CATEGORIAS
// 2. O PRESENTER PEDE A LISTA DE CAT. NO MODEL
// 3. O MODEL DEVOLVE UMA LISTA List<String>
// 4. O PRESENTER FORMATA ESSA LISTA QUE É UMA STRING EM CATEGORY(MODEL)
// 5. O VIEW PEGA A LISTA DE List<Category> E CONVERTE PARA O List<CategoryItem>
