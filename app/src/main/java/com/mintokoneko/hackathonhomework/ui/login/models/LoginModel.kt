package com.mintokoneko.hackathonhomework.ui.login.models

import com.mintokoneko.hackathonhomework.shared.CurrentUser
import com.mintokoneko.hackathonhomework.ui.login.LoginContractor

class LoginModel() : LoginContractor.Model {
    override fun setUserCredentials(login: String, password: String) {
        CurrentUser.setCredentials(login, password)
    }
}