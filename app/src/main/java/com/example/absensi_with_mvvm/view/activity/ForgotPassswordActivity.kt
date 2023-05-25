package com.example.absensi_with_mvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_with_mvvm.databinding.ActivityForgotPassswordBinding

class ForgotPassswordActivity : AppCompatActivity() {

    lateinit var binding: ActivityForgotPassswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPassswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}