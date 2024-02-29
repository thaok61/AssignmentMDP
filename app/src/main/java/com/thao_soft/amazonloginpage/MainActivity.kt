package com.thao_soft.amazonloginpage

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.thao_soft.amazonloginpage.databinding.ActivityMainBinding
import com.thao_soft.amazonloginpage.model.UserUtils

class MainActivity : AppCompatActivity(), OnClickListener{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)
        binding.buttonSignIn.setOnClickListener(this)
        binding.buttonCreateAccount.setOnClickListener(this)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
        }
    }



    fun login() {
        val email = binding.inputEmail.text.toString()
        val password = binding.inputPassword.text.toString()
        var loginSuccessful = false
        if (email.isNotBlank() && password.isNotBlank()) {
            for (i in UserUtils.list.indices) {
                val user = UserUtils.list[i]
                if (user.email == email && user.password == password) {
                    loginSuccessful = true
                    break
                }
            }
        }
        if (loginSuccessful) {
            startForResult.launch(Intent(this, HomeActivity::class.java))
        } else {
            Toast.makeText(this, "Wrong password or username", Toast.LENGTH_SHORT).show()
        }
        KeyboardUtils.hideKeyboard(this)
    }

    fun createAccount() {
        startForResult.launch(Intent(this, CreateAccountActivity::class.java))
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_sign_in -> login()
            R.id.button_create_account -> createAccount()
        }
    }
}