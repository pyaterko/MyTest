package com.owl_laugh_at_wasted_time.mytest.domain.entity

data class Order(
    var id: Int = UNDEFINED_ID,
    var foodImage:String?="",
    var orderName:String?="",
    var discription:String?="",
    var price:String?=""
){
    companion object {
        const val UNDEFINED_ID = 0
    }
}
