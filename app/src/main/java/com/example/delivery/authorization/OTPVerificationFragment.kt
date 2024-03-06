package com.example.delivery.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.delivery.R

class OTPVerificationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_o_t_p_verification, container, false)
    }
    lateinit var editTexts: ArrayList<EditText>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()

        val btnSetPass = view.findViewById<Button>(R.id.fotpver_btnSetPass)

        btnSetPass.setOnClickListener {
            controller.navigate(R.id.newPasswordFragment)
        }

        var editText1 = view.findViewById<EditText>(R.id.otpver_et1)
        var editText2 = view.findViewById<EditText>(R.id.otpver_et2)
        var editText3 = view.findViewById<EditText>(R.id.otpver_et3)
        var editText4 = view.findViewById<EditText>(R.id.otpver_et4)
        var editText5 = view.findViewById<EditText>(R.id.otpver_et5)
        var editText6 = view.findViewById<EditText>(R.id.otpver_et6)

        editTexts = ArrayList()
        editTexts.add(editText1)
        editTexts.add(editText2)
        editTexts.add(editText3)
        editTexts.add(editText4)
        editTexts.add(editText5)
        editTexts.add(editText6)


        for (i in 0 until editTexts.size) {
            val currentIndex = i
            editTexts[i].addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1) {
                        if (currentIndex < editTexts.size - 1) {
                            editTexts[currentIndex + 1].requestFocus() // Переход к следующему полю ввода
                        }
                    } else if (s?.length == 0 && currentIndex > 0) {
                        editTexts[currentIndex - 1].requestFocus() // Переход к предыдущему полю ввода при удалении символа
                    }
                    if (!s.isNullOrEmpty()) {
                        editTexts[i].setBackgroundResource(R.drawable.et_style_otp_with)
                    } else {
                        editTexts[i].setBackgroundResource(R.drawable.et_otp_without)
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // Не используется
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // Не используется
                }
            })
        }
    }
}