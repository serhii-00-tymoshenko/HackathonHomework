package com.mintokoneko.hackathonhomework.ui.registration

import android.content.Context
import com.mintokoneko.hackathonhomework.data.models.Credentials

interface RegistrationContractor {
    interface View {
        fun register()
        fun showLoginPage()
    }

    interface Model {
        fun setUserCredentials(login: String, password: String)
    }

    interface Presenter {
        fun onRegisterClick(login: String, password: String)
        fun onLoginClick()
    }
}