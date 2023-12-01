package com.mintokoneko.hackathonhomework.ui.employees.models

import com.mintokoneko.hackathonhomework.R
import com.mintokoneko.hackathonhomework.data.models.Credentials
import com.mintokoneko.hackathonhomework.data.models.Employee
import com.mintokoneko.hackathonhomework.data.models.Position
import com.mintokoneko.hackathonhomework.data.models.TrustLevel
import com.mintokoneko.hackathonhomework.shared.CurrentUser
import com.mintokoneko.hackathonhomework.ui.employees.EmployeesContractor

class EmployeesModel : EmployeesContractor.Model {
    override fun getUserCredentials(): Credentials = CurrentUser.getCredentials()

    override fun getEmployees(): List<Employee> {
        return listOf(
            Employee("Serhii", id = 0),
            Employee("Dmytro", position = Position.ADMIN, trustLevel = TrustLevel.GREEN, id = 1),
            Employee("Oleksandr", photo = R.drawable.ic_launcher_foreground, trustLevel = TrustLevel.RED, id = 2)
        )
    }
}