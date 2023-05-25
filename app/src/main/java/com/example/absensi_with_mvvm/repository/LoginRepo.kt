package com.example.absensi_with_mvvm.repository

import android.util.Log
import android.widget.Toast
import com.example.absensi_with_mvvm.model.LoginResponse
import com.example.absensi_with_mvvm.network.ApiConfig
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo {

    val apiConfig = ApiConfig()

    fun login(nik: String, password: String?,onResult: (result : LoginResponse)-> Unit){
        apiConfig.server.login(nik, password!!).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginSuccess(response, onResult)
//                loginSuccess(response, onResult)

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("repo-login", "onResponse-error: ${t.message}")
            }
        })
    }

    fun loginSuccess(response : Response<LoginResponse>, onResult: (result: LoginResponse) -> Unit){
        when(response.code()){
            200 -> {
                onResult(response.body()!!)
            }
            400 -> {
                var jsonObject : JSONObject? = null
                var default : LoginResponse? = null
                jsonObject = JSONObject(response.errorBody()!!.string())
                val message = jsonObject.getString("message")
                default = LoginResponse(message = message)
                onResult(default!!)
            }
        }
    }

}