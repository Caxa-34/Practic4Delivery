package com.example.delivery.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.delivery.R

class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val btnNext = view.findViewById<Button>(R.id.f2btnNext)
        val btnSkip = view.findViewById<Button>(R.id.f2btnSkip)

        btnSkip.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }

        btnNext.setOnClickListener {
            controller.navigate(R.id.blankFragment3)
        }
    }
}