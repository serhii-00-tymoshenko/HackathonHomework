package com.mintokoneko.hackathonhomework.ui.employees

import com.mintokoneko.hackathonhomework.data.models.Credentials
import com.mintokoneko.hackathonhomework.data.models.Employee

class EmployeesContractor {
    interface View {
        fun showDetailsPage(employee: Employee)
    }

    interface Model {
        fun getUserCredentials(): Credentials
        fun getEmployees(): List<Employee>
    }

    interface Presenter {
        fun loadItems(): List<Employee>
        fun onItemClick(employee: Employee)
    }
}