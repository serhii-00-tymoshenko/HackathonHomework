package com.mintokoneko.hackathonhomework.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mintokoneko.hackathonhomework.databinding.FragmentLoginBinding
import com.mintokoneko.hackathonhomework.ui.employees.EmployeesFragment
import com.mintokoneko.hackathonhomework.ui.login.models.LoginModel
import com.mintokoneko.hackathonhomework.utils.CustomFragmentManager

class LoginFragment : Fragment(), LoginContractor.View {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = LoginPresenter(this@LoginFragment, LoginModel())

        binding.apply {
            login.setOnClickListener {
                val login = loginField.editText?.text.toString()
                val password = passwordField.editText?.text.toString()

                if (login.isNotEmpty() && password.isNotEmpty()) {
                    presenter.onLoginClick(login, password)
                } else {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "Login"
    }

    override fun login() {
        val employeesFragment = EmployeesFragment()
        CustomFragmentManager.startTransaction(employeesFragment, EmployeesFragment.TAG)
    }
}