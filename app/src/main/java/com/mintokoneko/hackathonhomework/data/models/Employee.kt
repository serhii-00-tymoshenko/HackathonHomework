package com.mintokoneko.hackathonhomework.data.models

import android.os.Parcelable
import com.mintokoneko.hackathonhomework.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee(
    val name: String,
    val photo: Int = R.drawable.ic_launcher_background,
    val position: Position = Position.EMPLOYEE,
    val trustLevel: TrustLevel = TrustLevel.YELLOW,
    val id: Int
) : Parcelable

enum class Position {
    EMPLOYEE, ADMIN
}

enum class TrustLevel {
    YELLOW, GREEN, RED
}

