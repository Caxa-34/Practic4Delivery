package com.example.delivery

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.delivery.R

class splashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val sharedPref = context?.getSharedPreferences("deliveryProgramm", Context.MODE_PRIVATE)
        var isLogIn : Boolean = sharedPref?.getBoolean("isLogIn", false) ?: return

        if (!isLogIn) {
            Handler(Looper.getMainLooper()).postDelayed({
                controller.navigate(R.id.blankFragment1)
            }, 1500)
        }
        else {
            Handler(Looper.getMainLooper()).postDelayed({
                controller.navigate(R.id.mainFragment)
            }, 1500)
        }
    }
}