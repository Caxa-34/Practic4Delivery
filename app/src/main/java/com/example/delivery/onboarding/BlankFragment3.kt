package com.example.delivery.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.delivery.R

class BlankFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val btnSignup = view.findViewById<Button>(R.id.f3btnSignUp)
        val btnSignin = view.findViewById<TextView>(R.id.f3btnSignIn)
        //val btnSingin = view.findViewById<Button>(R.id.f3btnSingIn)

        btnSignup.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
        btnSignin.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
    }
}