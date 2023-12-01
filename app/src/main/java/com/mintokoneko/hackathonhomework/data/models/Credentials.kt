package com.mintokoneko.hackathonhomework.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Credentials(
    val login: String,
    val password: String
) : Parcelable
