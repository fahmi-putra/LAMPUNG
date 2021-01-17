package com.example.lampung

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lampung(
        var name: String? = "",
        var detail: String? = "",
        var photo: Int = 0
) : Parcelable