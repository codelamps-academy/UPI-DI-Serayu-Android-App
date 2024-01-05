package com.codelamps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codelamps.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private val binding : ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginStart.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registrasi.setOnClickListener{
            val intent = Intent(this, RegistrasiActivity::class.java)
            startActivity(intent)
        }
    }
}
