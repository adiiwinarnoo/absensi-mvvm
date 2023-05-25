package com.example.absensi_with_mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.absensi_with_mvvm.model.LoginResponse
import com.example.absensi_with_mvvm.repository.LoginRepo

class LoginViewModel : ViewModel() {

    private val loginRepository = LoginRepo()
    var _dataLogin = MutableLiveData<LoginResponse>()
    var dataLogin : LiveData<LoginResponse> = _dataLogin

    fun setLogin(nik : String, passsword : String) : MutableLiveData<LoginResponse> {
        loginRepository.login(nik, passsword) {
           _dataLogin.postValue(it)
        }
        Log.d("repo-login-3", "setLogin: asdadas")
        return _dataLogin
    }

}