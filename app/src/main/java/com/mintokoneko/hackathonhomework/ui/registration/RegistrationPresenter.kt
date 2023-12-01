package com.mintokoneko.hackathonhomework.ui.registration

import com.mintokoneko.hackathonhomework.shared.CurrentUser

class RegistrationPresenter(
    private val view: RegistrationContractor.View,
    private val model: RegistrationContractor.Model,
) : RegistrationContractor.Presenter {
    override fun onRegisterClick(login: String, password: String) {
        model.setUserCredentials(login, password)
        view.register()
    }

    override fun onLoginClick() {
        view.showLoginPage()
    }
}