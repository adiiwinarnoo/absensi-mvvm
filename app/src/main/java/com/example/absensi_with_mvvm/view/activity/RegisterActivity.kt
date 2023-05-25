package com.example.absensi_with_mvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_with_mvvm.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}