package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    // VIEW <- PRESENTER
    // PRESENTER -> VIEW
    fun findAllCategory() {
        fakeRequest()

    }

    fun onSuccess(response: List<Category>) {
        val categories = mutableListOf<CategoryItem>()
        for (category in response) {
            categories.add(CategoryItem(category))
        }

        view.showCategories(categories)


    }

    //simula requisição HTTP
    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xfface6e)
            )
            //aqui a lista já está pronta
            onSuccess(response)
        }, 2000)
    }

}