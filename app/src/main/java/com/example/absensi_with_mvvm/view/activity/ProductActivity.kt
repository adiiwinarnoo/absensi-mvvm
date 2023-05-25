package com.example.absensi_with_mvvm.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.absensi_with_mvvm.databinding.ActivityProductBinding
import com.example.absensi_with_mvvm.view.adapter.ProductAdapter
import com.example.absensi_with_mvvm.viewmodel.ProductViewModel

class ProductActivity : AppCompatActivity() {

    lateinit var binding : ActivityProductBinding
    lateinit var productViewModel: ProductViewModel
    lateinit var adapterProduct : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        productViewModel.getProduct()

        productViewModel.addDummyDataList.observe(this){
            adapterProduct = ProductAdapter(it)
            adapterProduct.notifyDataSetChanged()
            binding.recyclerView.adapter = adapterProduct
        }

        adapterProduct.setItemClick(object : ProductAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                startActivity(Intent(this@ProductActivity,PaymentMidtrans::class.java))
            }
        })



    }
}