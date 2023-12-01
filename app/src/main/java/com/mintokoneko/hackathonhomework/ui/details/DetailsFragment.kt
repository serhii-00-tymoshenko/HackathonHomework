package com.mintokoneko.hackathonhomework.ui.details

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mintokoneko.hackathonhomework.data.models.Employee
import com.mintokoneko.hackathonhomework.databinding.FragmentDetailsBinding
import com.mintokoneko.hackathonhomework.ui.details.models.DetailsModel
import com.mintokoneko.hackathonhomework.utils.getEmployeePosition
import com.mintokoneko.hackathonhomework.utils.getEmployeeTrustLevel
import com.mintokoneko.hackathonhomework.utils.getEmployeeTrustLevelColor

class DetailsFragment : Fragment(), DetailsContractor.View {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: DetailsPresenter

    private val employee by lazy {
        val emptyEmployee = Employee("", id = 0)
        val employee = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(EMPLOYEE_PARAM, Employee::class.java) ?: emptyEmployee
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable<Employee>(EMPLOYEE_PARAM)
                ?: emptyEmployee
        }
        employee
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DetailsPresenter(this, DetailsModel())
        presenter.onLoadDetails(requireContext())
    }

    companion object {
        private const val EMPLOYEE_PARAM = "Employee"
        const val TAG = "Details"

        @JvmStatic
        fun newInstance(employee: Employee) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(EMPLOYEE_PARAM, employee)
            }
        }
    }

    override fun showDetails(employeeDescription: String, context: Context) {
        binding.apply {
            description.text = employeeDescription
            photo.setImageResource(employee.photo)
            name.text = employee.name

            val employeePosition = getEmployeePosition(employee.position)
            position.text = employeePosition

            val employeeTrustLevel = getEmployeeTrustLevel(employee.trustLevel)
            trustLevel.text = employeeTrustLevel

            val employeeTrustLevelColor = getEmployeeTrustLevelColor(employee.trustLevel, context)
            trustLevel.setTextColor(employeeTrustLevelColor)
        }
    }
}