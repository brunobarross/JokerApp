package co.tiagoaguiar.tutorial.jokerappdev.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.tutorial.jokerappdev.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(private val category: co.tiagoaguiar.tutorial.jokerappdev.model.Category) :
    Item<CategoryItem.CategoryViewHolder>() {
    class CategoryViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View) = CategoryViewHolder(itemView)

    //tem a celula atual
    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.category_name).text = category.name
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category)
            .setBackgroundColor(category.bgColor.toInt())
    }

    //layout específico da célula
    override fun getLayout(): Int = R.layout.home_category_item
}