package com.mintokoneko.hackathonhomework.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mintokoneko.hackathonhomework.R
import com.mintokoneko.hackathonhomework.databinding.FragmentRegistrationBinding
import com.mintokoneko.hackathonhomework.ui.employees.EmployeesFragment
import com.mintokoneko.hackathonhomework.ui.login.LoginFragment
import com.mintokoneko.hackathonhomework.ui.registration.models.RegistrationModel
import com.mintokoneko.hackathonhomework.utils.CustomFragmentManager

class RegistrationFragment : Fragment(), RegistrationContractor.View {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: RegistrationPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = RegistrationPresenter(this@RegistrationFragment, RegistrationModel())

        binding.apply {
            register.setOnClickListener {
                val login = loginField.editText?.text.toString()
                val password = passwordField.editText?.text.toString()

                if (login.isNotEmpty() && password.isNotEmpty()) {
                    presenter.onRegisterClick(login, password)
                } else {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            login.setOnClickListener {
                presenter.onLoginClick()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "Registration"
    }

    override fun register() {
        val employeesFragment = EmployeesFragment()
        CustomFragmentManager.startTransaction(employeesFragment, EmployeesFragment.TAG)
    }

    override fun showLoginPage() {
        val loginFragment = LoginFragment()
        CustomFragmentManager.startTransaction(loginFragment, LoginFragment.TAG)
    }

}
