package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xwray.groupie.GroupieAdapter

class JokeFragment : Fragment() {
    private lateinit var presenter: JokePresenter
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    companion object {
        //garanto que eu vá passar sempre o mesmo valor
        const val CATEGORY_KEY = "category"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokePresenter(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.joke_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString((CATEGORY_KEY))
        val fbtn = view.findViewById<FloatingActionButton>(R.id.fab)
        progressBar = view.findViewById(R.id.joke_progress_bar)
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.title =
            categoryName?.replaceFirstChar { char -> char.titlecase() }

        presenter.findJoke(categoryName.toString())
        fbtn.setOnClickListener {
            presenter.findJoke(categoryName.toString())
        }


    }

    fun showJoke(response: Joke) {
        adapter.notifyDataSetChanged()
        val txt = view?.findViewById<TextView>(R.id.txt_joke)
        val icon = view?.findViewById<ImageView>(R.id.img_joke)
        txt?.text = response.value

    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}

