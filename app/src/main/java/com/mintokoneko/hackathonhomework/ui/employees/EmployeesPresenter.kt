package com.mintokoneko.hackathonhomework.ui.employees

import com.mintokoneko.hackathonhomework.data.models.Employee

class EmployeesPresenter(
    private val view: EmployeesContractor.View,
    private val model: EmployeesContractor.Model
) : EmployeesContractor.Presenter {
    override fun loadItems(): List<Employee> = model.getEmployees()

    override fun onItemClick(employee: Employee) {
        view.showDetailsPage(employee)
    }
}