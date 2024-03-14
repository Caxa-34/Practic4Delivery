package com.example.delivery.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.delivery.R
import com.example.delivery.databinding.FragmentProfileBinding
import com.example.delivery.databinding.FragmentWalletBinding
import java.text.DecimalFormat


class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    var isBalanceVisible = true
    var currentBalance :Float = 10712f
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        binding.fprofileBtnLogOut.setOnClickListener {
            controller.navigate(R.id.logInFragment)
        }
        binding.fprofileBtnCard.setOnClickListener {
            controller.navigate(R.id.addPayMethodFragment)
        }

        binding.fprofileBtnEditProfile.setOnClickListener {
        }

        binding.fprofileBtnStatements.setOnClickListener {
        }

        binding.fprofileBtnRefferals.setOnClickListener {
        }

        binding.fprofileBtnAboutUs.setOnClickListener {
        }

        binding.fprofileBtnNotificSet.setOnClickListener {
            controller.navigate(R.id.notificationSetFragment)
        }

        binding.fprofileBtnShowBalance.setOnClickListener {
            isBalanceVisible = !isBalanceVisible
            if (isBalanceVisible) {
                // Показать баланс
                binding.fprofileEtBalance.text = formatBalance(currentBalance)
            } else {
                // Скрыть баланс
                binding.fprofileEtBalance.text = "**********"
            }

            val drawableRes = if (isBalanceVisible) R.drawable.img_eye
            else R.drawable.img_eye_slash
            binding.fprofileBtnShowBalance.setImageResource(drawableRes)
        }

    }
    fun formatBalance(balance: Float): String {
        val decimalFormat = DecimalFormat("N##,###.00")
        return decimalFormat.format(balance)
    }
}