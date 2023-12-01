package com.mintokoneko.hackathonhomework.ui.login

interface LoginContractor {
    interface View {
        fun login()
    }

    interface Model {
        fun setUserCredentials(login: String, password: String)
    }

    interface Presenter {
        fun onLoginClick(login: String, password: String)
    }
}