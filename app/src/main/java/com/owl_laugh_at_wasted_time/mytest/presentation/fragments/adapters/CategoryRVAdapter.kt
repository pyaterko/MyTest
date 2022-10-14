package com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.owl_laugh_at_wasted_time.mytest.databinding.CategoryItemBinding
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Category

class CategoryRVAdapter : RecyclerView.Adapter<CategoryRVAdapter.CategoryViewHolder>() {

    var onItemClickListener: ((CategoryItemBinding) -> Unit)? = null

    var items: List<Category> = listOf(
        Category("Пицца"),
        Category("Комбо"),
        Category("Десерты"),
        Category("Напитки")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            onItemClickListener?.invoke(holder.binding)
        }

    }

    override fun getItemCount() = items.size

    class CategoryViewHolder(
        val binding: CategoryItemBinding,
        val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {
            with(binding) {
                tvName.text = item.name
            }
        }

    }

}