package com.owl_laugh_at_wasted_time.mytest.presintation.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.owl_laugh_at_wasted_time.mytest.databinding.FoodRowItemBinding
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order

class OrderRVAdapter: RecyclerView.Adapter<OrderRVAdapter.OrderViewHolder>() {


    var items: List<Order> = listOf(
        Order(),
        Order(),
        Order(),
        Order(),
        Order(),
        Order(),
        Order(),
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodRowItemBinding.inflate(inflater, parent, false)
        return OrderViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {


    }

    override fun getItemCount() = items.size

    class OrderViewHolder(
        val binding: FoodRowItemBinding,
        val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {


    }

}