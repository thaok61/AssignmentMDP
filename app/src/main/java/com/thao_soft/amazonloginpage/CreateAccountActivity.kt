package com.thao_soft.amazonloginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.thao_soft.amazonloginpage.databinding.ActivityCreateAccountBinding
import com.thao_soft.amazonloginpage.databinding.ActivityMainBinding
import com.thao_soft.amazonloginpage.model.User
import com.thao_soft.amazonloginpage.model.UserUtils

class CreateAccountActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_account)
        binding.buttonCreateAccount.setOnClickListener(this)
    }

    private fun createAccount() {
        val name = binding.nameTv.text.toString()
        val email = binding.mobileOrEmailTv.text.toString()
        val password = binding.passwordTv.text.toString()
        val rePassword = binding.reEnterTv.text.toString()

        if (name.isBlank()) {
            Toast.makeText(this, "Name is blank", Toast.LENGTH_SHORT).show()
        } else if (email.isBlank()) {
            Toast.makeText(this, "Email or Mobile number is blank", Toast.LENGTH_SHORT).show()
        } else {
            if (password != rePassword || password.length < 6) {
                Toast.makeText(this, "Password is not valid", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(email, password, name)
                var isDuplicate = false
                for (i in UserUtils.list.indices) {
                    if (user.email == UserUtils.list[i].email) {
                        Toast.makeText(this, "Email or Mobile number is exist in database", Toast.LENGTH_SHORT).show()
                        isDuplicate = true
                        break
                    }
                }
                if (!isDuplicate) {
                    UserUtils.list.add(user)
                    finish()
                }
            }
        }
        KeyboardUtils.hideKeyboard(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.button_create_account -> createAccount()
        }
    }
}