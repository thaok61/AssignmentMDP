package com.thao_soft.electronicgadgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.thao_soft.electronicgadgets.adapter.ProductAdapter
import com.thao_soft.electronicgadgets.data.ProductData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listProduct)
        recyclerView.adapter = ProductAdapter(ProductData.list, this)

        findViewById<Button>(R.id.viewCart).setOnClickListener {
            Toast.makeText(this, ProductData.cart.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}