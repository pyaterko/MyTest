package com.owl_laugh_at_wasted_time.mytest.data.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meal(
    val idIngredient: String,
    val strDescription: String,
    val strIngredient: String,
    val strType: String
):Parcelable