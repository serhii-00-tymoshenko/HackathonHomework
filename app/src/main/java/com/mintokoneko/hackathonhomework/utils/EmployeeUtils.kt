package com.mintokoneko.hackathonhomework.utils

import android.content.Context
import com.mintokoneko.hackathonhomework.R
import com.mintokoneko.hackathonhomework.data.models.Position
import com.mintokoneko.hackathonhomework.data.models.TrustLevel

fun getEmployeeTrustLevel(trustLevel: TrustLevel) = when (trustLevel) {
    TrustLevel.RED -> "Red"
    TrustLevel.GREEN -> "Green"
    TrustLevel.YELLOW -> "Yellow"
}

fun getEmployeeTrustLevelColor(trustLevel: TrustLevel, context: Context) = when (trustLevel) {
    TrustLevel.RED -> context.getColor(R.color.red)
    TrustLevel.GREEN -> context.getColor(R.color.green)
    TrustLevel.YELLOW -> context.getColor(R.color.yellow)
}

fun getEmployeePosition(position: Position) = when (position) {
    Position.EMPLOYEE -> "Employee"
    Position.ADMIN -> "Admin"
}
