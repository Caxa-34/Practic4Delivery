package com.example.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = findNavController()

        val btnSignup = view.findViewById<Button>(R.id.fsignup_btnSignUp)
        val btnSignin = view.findViewById<TextView>(R.id.fsignup_btnSignIn)

        btnSignup.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
        btnSignin.setOnClickListener {
            controller.navigate(R.id.logInFragment)
        }
    }
}