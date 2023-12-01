package com.mintokoneko.hackathonhomework.ui.login

class LoginPresenter(
    private val view: LoginContractor.View,
    private val model: LoginContractor.Model,
) : LoginContractor.Presenter {
    override fun onLoginClick(login: String, password: String) {
        model.setUserCredentials(login, password)
        view.login()
    }
}