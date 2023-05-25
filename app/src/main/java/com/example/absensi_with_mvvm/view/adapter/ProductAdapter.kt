package com.example.absensi_with_mvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.absensi_with_mvvm.R
import com.example.absensi_with_mvvm.model.ProductModel

class ProductAdapter(val models : List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var itemClickListener: ItemClickListener

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    fun setItemClick(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView) {
        var imageProduct: ImageView = itemView.findViewById(R.id.image_product)
        var tittleProduct : TextView = itemView.findViewById(R.id.tv_tittle_product)
        var priceProduct : TextView = itemView.findViewById(R.id.tv_price_product)

        fun bind(img : ProductModel){
            Glide.with(itemView).load(img.imageProduct).into(imageProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(models[position])
        holder.tittleProduct.text = models[position].tittleProduct
        holder.priceProduct.text = models[position].priceProduct
        holder.imageProduct.setOnClickListener {
            itemClickListener.onClick(it,position)
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }
}