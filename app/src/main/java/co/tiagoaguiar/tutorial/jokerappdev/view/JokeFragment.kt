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
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieAdapter
import org.w3c.dom.Text

class JokeFragment : Fragment() {
    private lateinit var presenter: JokePresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var txtJoke: TextView
    private lateinit var imgJoke: ImageView

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
        txtJoke = view.findViewById(R.id.txt_joke)
        imgJoke = view.findViewById(R.id.img_joke)

        presenter.findJoke(categoryName.toString())
        fbtn.setOnClickListener {
            presenter.findJoke(categoryName.toString())
        }


    }

    fun showJoke(response: Joke) {
        txtJoke.text = response.text
        Picasso.get().load(response.icon_url).placeholder(R.drawable.logo).into(imgJoke)
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

