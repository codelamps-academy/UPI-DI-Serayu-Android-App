package com.codelamps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.codelamps.databinding.ActivityRegistrasiBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegistrasiActivity : AppCompatActivity() {

    private val binding: ActivityRegistrasiBinding by lazy {
        ActivityRegistrasiBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    private lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth
        progressBar = binding.progressBarRegister

        binding.backRegister.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        binding.register.setOnClickListener {
//            progressBar.isVisible
            val fullname = binding.namaLengkap.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_LONG).show()
            }

            if (TextUtils.isEmpty(fullname)) {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_LONG).show()
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_LONG).show()
            }


            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
//                    progressBar.isGone
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("register", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

//            auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d("register", "createUserWithEmail:success")
//                        val user = auth.currentUser
//
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w("register", "createUserWithEmail:failure", task.exception)
//                        Toast.makeText(
//                            baseContext,
//                            "Authentication failed.",
//                            Toast.LENGTH_SHORT,
//                        ).show()
//                    }
//                }

        }


    }
}
