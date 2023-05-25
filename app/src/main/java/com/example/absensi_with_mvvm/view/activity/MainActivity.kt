package com.example.absensi_with_mvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absensi_with_mvvm.R
import com.example.absensi_with_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}