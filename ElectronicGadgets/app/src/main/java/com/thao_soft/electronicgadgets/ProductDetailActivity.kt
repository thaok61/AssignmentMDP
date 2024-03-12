package com.thao_soft.electronicgadgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.thao_soft.electronicgadgets.data.ProductData

class ProductDetailActivity : AppCompatActivity() {
    private var idx = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        idx = intent.getIntExtra("key", -1)
        val image = findViewById<ImageView>(R.id.image)
        Picasso.get().load(ProductData.list[idx].imageUrl).into(image)
        findViewById<TextView>(R.id.name).text = ProductData.list[idx].name
        findViewById<TextView>(R.id.cost).text = "$ ${ProductData.list[idx].cost}"
        findViewById<TextView>(R.id.productDescription).text = ProductData.list[idx].description

        findViewById<Button>(R.id.home).setOnClickListener { _ ->
            finish()
        }
    }
}