package com.owl_laugh_at_wasted_time.mytest.presentation.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.owl_laugh_at_wasted_time.mytest.databinding.DiscountsItemBinding
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Discount

class DiscountRVAdapter: RecyclerView.Adapter<DiscountRVAdapter.DiscountViewHolder>() {


    var items: List<Discount> = listOf(
        Discount(),
        Discount(),
        Discount()
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DiscountsItemBinding.inflate(inflater, parent, false)
        return DiscountViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {


    }

    override fun getItemCount() = items.size

    class DiscountViewHolder(
        val binding: DiscountsItemBinding,
        val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {


    }

}