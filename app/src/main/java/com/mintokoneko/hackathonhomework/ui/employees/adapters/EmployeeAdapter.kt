package com.mintokoneko.hackathonhomework.ui.employees.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mintokoneko.hackathonhomework.data.models.Employee
import com.mintokoneko.hackathonhomework.databinding.ItemEmployeeBinding
import com.mintokoneko.hackathonhomework.utils.getEmployeePosition
import com.mintokoneko.hackathonhomework.utils.getEmployeeTrustLevel
import com.mintokoneko.hackathonhomework.utils.getEmployeeTrustLevelColor

class EmployeeAdapter(
    private val onItemClick: (Employee) -> Unit
) : ListAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Employee>() {
            override fun areItemsTheSame(oldItem: Employee, newItem: Employee) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Employee, newItem: Employee) =
                oldItem == newItem
        }
    }

    inner class EmployeeViewHolder(private val binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(employee: Employee) {
            binding.apply {
                root.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        onItemClick(employee)
                    }
                }

                name.text = employee.name
                photo.setImageResource(employee.photo)

                val employeePosition = getEmployeePosition(employee.position)
                position.text = employeePosition

                val employeeTrustLevel = getEmployeeTrustLevel(employee.trustLevel)
                trustLevel.text = employeeTrustLevel

                val employeeTrustLevelColor =
                    getEmployeeTrustLevelColor(employee.trustLevel, itemView.context)
                trustLevel.setTextColor(employeeTrustLevelColor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding =
            ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val currentEmployee = getItem(position)
        holder.bind(currentEmployee)
    }
}