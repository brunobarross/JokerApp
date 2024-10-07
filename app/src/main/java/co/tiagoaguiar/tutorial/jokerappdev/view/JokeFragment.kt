package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.model.Joker
import com.xwray.groupie.GroupieAdapter
import retrofit2.Response

class JokeFragment : Fragment() {
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    companion object {
        //garanto que eu vá passar sempre o mesmo valor
        const val CATEGORY_KEY = "category"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.joke_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString((CATEGORY_KEY))
        Log.d("Teste", categoryName.toString())
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.title =
            categoryName?.replaceFirstChar { char -> char.titlecase() }


    }

}

