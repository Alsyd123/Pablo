package com.alsyd123.pablo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var registerButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        nameInput = findViewById(R.id.nameInput)
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput)
        registerButton = findViewById(R.id.registerButton)
        backButton = findViewById(R.id.backButton)

        // Set click listeners
        registerButton.setOnClickListener {
            handleRegister()
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun handleRegister() {
        val name = nameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()
        val confirmPassword = confirmPasswordInput.text.toString().trim()

        when {
            name.isEmpty() -> {
                Toast.makeText(this, "الرجاء إدخال الاسم", Toast.LENGTH_SHORT).show()
                nameInput.requestFocus()
            }
            email.isEmpty() -> {
                Toast.makeText(this, "الرجاء إدخال البريد الإلكتروني", Toast.LENGTH_SHORT).show()
                emailInput.requestFocus()
            }
            password.isEmpty() -> {
                Toast.makeText(this, "الرجاء إدخال كلمة المرور", Toast.LENGTH_SHORT).show()
                passwordInput.requestFocus()
            }
            !isValidEmail(email) -> {
                Toast.makeText(this, "البريد الإلكتروني غير صحيح", Toast.LENGTH_SHORT).show()
            }
            password.length < 6 -> {
                Toast.makeText(this, "كلمة المرور يجب أن تكون 6 أحرف على الأقل", Toast.LENGTH_SHORT).show()
            }
            password != confirmPassword -> {
                Toast.makeText(this, "كلمات المرور غير متطابقة", Toast.LENGTH_SHORT).show()
            }
            else -> {
                // Registration successful
                Toast.makeText(this, "تم التسجيل بنجاح! يرجى تسجيل الدخول", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
