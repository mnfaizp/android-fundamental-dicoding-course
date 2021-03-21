package com.example.fundamental

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var photo: String,
    var name: String,
    var desc: String
) : Parcelable
