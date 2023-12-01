package com.mintokoneko.hackathonhomework.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.mintokoneko.hackathonhomework.R
import com.mintokoneko.hackathonhomework.ui.login.LoginFragment

class CustomFragmentManager {
    companion object {
        private var activity: AppCompatActivity? = null


        fun setActivity(activity: AppCompatActivity) {
            this.activity = activity
        }

        fun startTransaction(fragment: Fragment, tag: String) {
            activity?.let { activity ->
                val fragmentManager = activity.supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(tag)
                    .commit()
            }
        }

        fun clearBackStackAndAdd(fragment: Fragment) {
            activity?.let { activity ->
                val fragmentManager = activity.supportFragmentManager
                val firstFragmentName = fragmentManager.getBackStackEntryAt(0).name
                fragmentManager.popBackStackImmediate(firstFragmentName, FragmentManager.POP_BACK_STACK_INCLUSIVE)

                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                    .commit()
            }
        }
    }
}

