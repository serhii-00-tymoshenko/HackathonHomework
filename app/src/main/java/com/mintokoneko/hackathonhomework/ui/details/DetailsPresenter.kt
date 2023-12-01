package com.mintokoneko.hackathonhomework.ui.details

import android.content.Context

class DetailsPresenter(
    private val view: DetailsContractor.View,
    private val model: DetailsContractor.Model
) : DetailsContractor.Presenter {
    override fun onLoadDetails(context: Context) {
        val description = model.getEmployeeDescription()
        view.showDetails(description, context)
    }
}