package com.thao_soft.amazonloginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.thao_soft.amazonloginpage.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        
        binding.kitchenLayout.setOnClickListener(this)
        binding.makeupLayout.setOnClickListener(this)
        binding.petFoodLayout.setOnClickListener(this)
        binding.constructionLayout.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.kitchenLayout -> {
                Toast.makeText(this, "Home and Kitchen", Toast.LENGTH_SHORT).show()
            }

            R.id.makeupLayout -> {
                Toast.makeText(this, "Beauty and personal care", Toast.LENGTH_SHORT).show()
            }

            R.id.petFoodLayout -> {
                Toast.makeText(this, "Pet supplies", Toast.LENGTH_SHORT).show()
            }

            R.id.constructionLayout -> {
                Toast.makeText(this, "Toys and games", Toast.LENGTH_SHORT).show()
            }
        }
    }


}