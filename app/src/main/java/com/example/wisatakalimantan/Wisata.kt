package com.example.wisatakalimantan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    var photo: Int,
    var name: String,
    var description: String,
    var address: String,
    var area: String,
    var type: String
) : Parcelable
