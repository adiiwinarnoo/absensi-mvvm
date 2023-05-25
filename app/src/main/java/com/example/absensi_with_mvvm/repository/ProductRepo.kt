package com.example.absensi_with_mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.example.absensi_with_mvvm.R
import com.example.absensi_with_mvvm.model.LoginResponse
import com.example.absensi_with_mvvm.model.ProductModel
import com.example.absensi_with_mvvm.network.ApiConfig

class ProductRepo {

    val apiConfig = ApiConfig()
    var dataProductModel = mutableListOf<ProductModel>()
    val dummyDataList: List<ProductModel>
        get() = dataProductModel

    fun setProduct(){
        dataProductModel.addAll(listOf(
            ProductModel(R.drawable.hp2, "HP ANDROID TERBARU 2023", "Rp. 5.100.000"),
            ProductModel(R.drawable.hp4, "HP ANDROID TERBARU 2023", "Rp. 4.200.000"),
        ))
    }


}