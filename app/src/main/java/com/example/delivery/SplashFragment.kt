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
        var cnt : Int = sharedPref?.getInt("cnt", 0) ?: return

        if (cnt == 0) {
            Handler(Looper.getMainLooper()).postDelayed({
                controller.navigate(R.id.blankFragment1)
            }, 1500)
        }
        else {
            Handler(Looper.getMainLooper()).postDelayed({
                controller.navigate(R.id.logInFragment)
            }, 1500)
        }

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt("cnt", cnt + 1)
        editor.commit()
    }
}