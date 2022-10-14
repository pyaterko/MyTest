package com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.owl_laugh_at_wasted_time.mytest.databinding.FoodRowItemBinding
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order

class OrderRVAdapter : RecyclerView.Adapter<OrderRVAdapter.OrderViewHolder>() {

    var items: List<Order> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FoodRowItemBinding.inflate(inflater, parent, false)
        return OrderViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

    }

    override fun getItemCount() = items.size

    class OrderViewHolder(
        val binding: FoodRowItemBinding,
        val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Order) {
            with(binding) {
                if (item.orderName != "") {
                    orderName.text = item.orderName
                    discription.text = item.discription
                    price.text = item.foodImage
                }
            }
        }

    }

}