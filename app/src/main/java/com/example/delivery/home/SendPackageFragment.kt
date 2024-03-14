package com.example.delivery.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.delivery.R
import com.example.delivery.databinding.FragmentSendPackageBinding

class SendPackageFragment : Fragment() {
    private var _binding : FragmentSendPackageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSendPackageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    var cntDestDetails = 1;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.fsendpackBtnBack.setOnClickListener {
            controller.navigate(R.id.mainFragment)
        }
        binding.fsendpackBtnNext.setOnClickListener {
            nextClick(view)
        }
        binding.fsendpackBtnEditPackage.setOnClickListener {
            editPackageClick(view)
        }
        binding.fsendpackBtnMakePayment.setOnClickListener {
            makePaymentClick(view)
        }
        binding.fsendpackBtnAddDestin.setOnClickListener {
            if (cntDestDetails == 4) {
                binding.fsendpackBtnAddDestin.visibility = View.GONE
            }
            if (cntDestDetails < 5) {
                cntDestDetails++

                when (cntDestDetails) {
                    2 -> binding.fsendpackLlDestDetail2.visibility =
                        View.VISIBLE
                    3 -> binding.fsendpackLlDestDetail3.visibility =
                        View.VISIBLE
                    4 -> binding.fsendpackLlDestDetail4.visibility =
                        View.VISIBLE
                    5 -> binding.fsendpackLlDestDetail5.visibility =
                        View.VISIBLE
                }
            }
        }
        editPackageClick(view)
    }

    fun nextClick(view: View) {
        binding.fsendpackSvInputData.visibility = View.GONE
        binding.fsendpackSvOutputData.visibility = View.VISIBLE
    }
    fun editPackageClick(view: View) {
        binding.fsendpackSvInputData.visibility = View.VISIBLE
        binding.fsendpackSvOutputData.visibility = View.GONE
    }
    fun makePaymentClick(view: View) {
        val controller = findNavController()
        controller.navigate(R.id.transactionFragment)
    }

}