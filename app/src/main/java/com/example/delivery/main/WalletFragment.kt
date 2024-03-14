package com.example.delivery.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.delivery.R
import com.example.delivery.databinding.FragmentWalletBinding
import java.text.DecimalFormat

class WalletFragment : Fragment() {
    private var _binding : FragmentWalletBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    var isBalanceVisible = true
    var currentBalance :Float = 10712f
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fwalletBtnShowBalance.setOnClickListener {
            isBalanceVisible = !isBalanceVisible
            if (isBalanceVisible) {
                // Показать баланс
                binding.fwalletEtBalance.text = formatBalance(currentBalance)
            } else {
                // Скрыть баланс
                binding.fwalletEtBalance.text = "**********"
            }

            val drawableRes = if (isBalanceVisible) R.drawable.img_eye
            else R.drawable.img_eye_slash
            binding.fwalletBtnShowBalance.setImageResource(drawableRes)
        }
    }
    fun formatBalance(balance: Float): String {
        val decimalFormat = DecimalFormat("N###,###.00")
        return decimalFormat.format(balance)
    }

}