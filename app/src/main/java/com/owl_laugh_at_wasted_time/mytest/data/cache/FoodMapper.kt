package com.owl_laugh_at_wasted_time.mytest.data.cache

import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order
import javax.inject.Inject


class FoodMapper @Inject constructor() {

    fun mapEntityToDbModel(item: Order) = OrderDbModel(
        id = item.id,
        foodImage = item.foodImage,
        orderName = item.orderName,
        discription = item.discription,
        price = item.price
    )

    fun mapDbModelToEntity(item: OrderDbModel) = Order(
        id = item.id,
        foodImage = item.foodImage,
        orderName = item.orderName,
        discription = item.discription,
        price = item.price
    )

    fun mapListDbModelToListEntity(list: List<OrderDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

    fun mapListEntityToListDbModel(list: List<Order>) = list.map {
        mapEntityToDbModel(it)
    }
}