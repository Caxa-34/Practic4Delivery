package com.example.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class ForgotPasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = findNavController()

        val btnSignin = view.findViewById<TextView>(R.id.fforgot_btnSignIn)
        val btnSend = view.findViewById<Button>(R.id.fforgot_btnSendOTP)

        btnSend.setOnClickListener {
            controller.navigate(R.id.OTPVerificationFragment)
        }
        btnSignin.setOnClickListener {
            controller.navigate(R.id.logInFragment)
        }

    }
}