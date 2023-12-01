package com.mintokoneko.hackathonhomework.shared

import com.mintokoneko.hackathonhomework.data.models.Credentials

object CurrentUser {
    private lateinit var credentials: Credentials

    fun setCredentials(login: String, password: String) {
        credentials = Credentials(login, password)
    }

    fun getCredentials(): Credentials = credentials
}