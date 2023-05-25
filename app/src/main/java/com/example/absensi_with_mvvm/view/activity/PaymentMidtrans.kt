package com.example.absensi_with_mvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_with_mvvm.databinding.ActivityPaymentMidtransBinding

class PaymentMidtrans : AppCompatActivity() {

    lateinit var binding : ActivityPaymentMidtransBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMidtransBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}