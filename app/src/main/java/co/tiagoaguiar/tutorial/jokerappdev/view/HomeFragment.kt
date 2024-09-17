package co.tiagoaguiar.tutorial.jokerappdev.view

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {
    private lateinit var presenter: HomePresenter
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_home)
        recyclerView.layoutManager = LinearLayoutManager(requireContext()) //busca o contexto
        progressBar = view.findViewById(R.id.home_progress_bar)
        presenter.findAllCategory()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun showCategories(response: List<Category>) {
        val categories = response.map { category -> CategoryItem(category) }
        adapter.addAll(categories)
        adapter.notifyDataSetChanged()

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