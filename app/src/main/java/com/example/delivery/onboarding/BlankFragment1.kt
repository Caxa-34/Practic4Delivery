package com.example.delivery.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.delivery.R

class BlankFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val btnNext = view.findViewById<Button>(R.id.f1btnNext)
        val btnSkip = view.findViewById<Button>(R.id.f1btnSkip)

        btnSkip.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
        btnNext.setOnClickListener {
            controller.navigate(R.id.blankFragment2)
        }
    }
}