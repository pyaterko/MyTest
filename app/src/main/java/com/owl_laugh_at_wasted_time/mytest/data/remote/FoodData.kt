package com.owl_laugh_at_wasted_time.mytest.data.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodData(
    val meals: List<Meal>
):Parcelable