package com.example.absensi_with_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.absensi_with_mvvm.model.ProductModel
import com.example.absensi_with_mvvm.repository.ProductRepo

class ProductViewModel : ViewModel() {

    private val productRepository = ProductRepo()

    val addDummyDataList : LiveData<List<ProductModel>> = MutableLiveData(productRepository.dummyDataList)

    fun getProduct(){
        productRepository.setProduct()
    }
}