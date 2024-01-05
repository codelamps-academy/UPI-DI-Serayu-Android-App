package com.codelamps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.codelamps.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding : ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
