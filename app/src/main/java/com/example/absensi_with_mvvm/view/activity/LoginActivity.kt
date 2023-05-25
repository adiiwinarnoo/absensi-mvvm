package com.example.absensi_with_mvvm.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.absensi_with_mvvm.databinding.ActivityLoginBinding
import com.example.absensi_with_mvvm.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var loginViewModel : LoginViewModel
    var nik = ""
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginViewModel._dataLogin.observe(this) {
            if (it.status == 1) {
                startActivity(Intent(this, ProductActivity::class.java))
            } else {
                Toast.makeText(this, "gagal login", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnLupaPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPassswordActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
           checkedLogin()
        }
    }

    private fun loggedIn(nik:String,password:String) {
        loginViewModel.setLogin(nik,password)
    }

    private fun checkedLogin(){
        if (binding.edtMasukanNik.text.isEmpty()){
            binding.edtMasukanNik.error = "Masukan NIK"
            binding.edtMasukanNik.requestFocus()
        }else if (binding.edtPassword.text.isEmpty()){
            binding.edtPassword.error = "Masukan Password"
            binding.edtPassword.requestFocus()
        }else{
            nik = binding.edtMasukanNik.text.toString()
            password = binding.edtPassword.text.toString()
            loggedIn(nik,password)
        }
    }

}