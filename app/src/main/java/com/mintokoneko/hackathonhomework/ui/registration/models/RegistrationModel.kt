package com.mintokoneko.hackathonhomework.ui.registration.models

import com.mintokoneko.hackathonhomework.shared.CurrentUser
import com.mintokoneko.hackathonhomework.ui.registration.RegistrationContractor

class RegistrationModel() : RegistrationContractor.Model {
    override fun setUserCredentials(login: String, password: String) {
        CurrentUser.setCredentials(login, password)
    }
}