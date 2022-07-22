package com.example.capstorefinal.domain.model

import java.io.Serializable

data class Cap(
    val companyName: String,
    val seriesName: String,
    val oldCost: Int,
    val newCost: Boolean,
    val image: Int,
    val statusFavourites: Boolean,
    val statusBestsellers: Boolean,
    val statusDiscount: Boolean,
    var id: Int = UNDEFINED_ID
) : Serializable {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
