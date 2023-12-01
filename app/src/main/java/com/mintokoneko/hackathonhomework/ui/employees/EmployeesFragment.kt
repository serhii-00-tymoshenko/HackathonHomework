package com.mintokoneko.hackathonhomework.ui.employees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mintokoneko.hackathonhomework.data.models.Employee
import com.mintokoneko.hackathonhomework.databinding.FragmentEmployeesBinding
import com.mintokoneko.hackathonhomework.ui.details.DetailsFragment
import com.mintokoneko.hackathonhomework.ui.employees.adapters.EmployeeAdapter
import com.mintokoneko.hackathonhomework.ui.employees.models.EmployeesModel
import com.mintokoneko.hackathonhomework.utils.CustomFragmentManager

class EmployeesFragment : Fragment(), EmployeesContractor.View {
    private var _binding: FragmentEmployeesBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: EmployeesPresenter
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = EmployeesPresenter(this@EmployeesFragment, EmployeesModel())

        employeeAdapter = EmployeeAdapter { employee ->
            presenter.onItemClick(employee)
        }
        setupRecycler()

        val employees = presenter.loadItems()
        employeeAdapter.submitList(employees)
    }

    private fun setupRecycler() {
        val recycler = binding.employees
        recycler.apply {
            adapter = employeeAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        CustomFragmentManager.clearBackStackAndAdd(this@EmployeesFragment, TAG)
        _binding = null
    }

    companion object {
        const val TAG = "Employees"
    }

    override fun showDetailsPage(employee: Employee) {
        val detailsFragment = DetailsFragment.newInstance(employee)
        CustomFragmentManager.startTransaction(detailsFragment, DetailsFragment.TAG)
    }
}