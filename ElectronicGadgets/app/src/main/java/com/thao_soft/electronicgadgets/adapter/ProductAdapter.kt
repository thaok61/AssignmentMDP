package com.thao_soft.electronicgadgets.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import com.thao_soft.electronicgadgets.ProductDetailActivity
import com.thao_soft.electronicgadgets.R
import com.thao_soft.electronicgadgets.data.ProductData
import com.thao_soft.electronicgadgets.model.Product

class ProductAdapter(private val products: List<Product>, private val context: Context):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(view: View): ViewHolder(view) {
        val productImage: ImageView
        val productLogo: ImageView
        val productName: TextView
        val cost: TextView
        val productDescription: TextView
        val addButton: Button


        init {
            addButton = view.findViewById(R.id.addButton)
            productImage = view.findViewById(R.id.image)
            productLogo = view.findViewById(R.id.logo)
            productName = view.findViewById(R.id.productName)
            cost = view.findViewById(R.id.cost)
            productDescription = view.findViewById(R.id.productDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_view, parent, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.itemView.setOnClickListener { _ ->
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("key", position)
            context.startActivity(intent)
        }

        holder.addButton.setOnClickListener { _ ->
            ProductData.cart.add(products[position])
        }
        holder.productName.text = products[position].name
        holder.productDescription.text = products[position].description
        holder.cost.text = "$ ${products[position].cost}"
        if (products[position].imageUrl.isNotBlank()) {
            Picasso.get().load(products[position].imageUrl).into(holder.productImage)
        }

        if (products[position].logo.isNotBlank()){
            Picasso.get().load(products[position].logo).into(holder.productLogo)
        }

    }
}