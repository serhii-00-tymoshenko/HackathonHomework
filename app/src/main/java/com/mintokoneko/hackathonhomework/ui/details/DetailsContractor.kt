package com.mintokoneko.hackathonhomework.ui.details

import android.content.Context

interface DetailsContractor {
    interface View {
        fun showDetails(employeeDescription: String, context: Context)
    }

    interface Model {
        fun getEmployeeDescription(): String
    }

    interface Presenter {
        fun onLoadDetails(context: Context)
    }
}