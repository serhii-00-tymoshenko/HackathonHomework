package com.mintokoneko.hackathonhomework.ui.details.models

import com.mintokoneko.hackathonhomework.R
import com.mintokoneko.hackathonhomework.data.models.Credentials
import com.mintokoneko.hackathonhomework.data.models.Employee
import com.mintokoneko.hackathonhomework.data.models.Position
import com.mintokoneko.hackathonhomework.data.models.TrustLevel
import com.mintokoneko.hackathonhomework.shared.CurrentUser
import com.mintokoneko.hackathonhomework.ui.details.DetailsContractor
import com.mintokoneko.hackathonhomework.ui.employees.EmployeesContractor

class DetailsModel : DetailsContractor.Model {
    override fun getEmployeeDescription(): String = "Some description"
}