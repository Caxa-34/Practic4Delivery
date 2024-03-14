package com.example.delivery.navigation

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
import com.example.delivery.databinding.FragmentSplashBinding

class splashFragment : Fragment() {

    private var _binding :FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
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