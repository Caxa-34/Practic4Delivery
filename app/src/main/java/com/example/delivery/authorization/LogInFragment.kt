package com.example.delivery.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.delivery.R

class LogInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val btnSignup = view.findViewById<Button>(R.id.flogin_btnLogIn)
        val btnForgot = view.findViewById<TextView>(R.id.flogin_btnForgotPassword)
        val btnSignin = view.findViewById<TextView>(R.id.flogin_btnSignIn)

        btnSignup.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
        btnSignin.setOnClickListener {
            controller.navigate(R.id.signUpFragment)
        }
        btnForgot.setOnClickListener {
            controller.navigate(R.id.forgotPasswordFragment)
        }
    }

}