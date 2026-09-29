package com.alsyd123.pablo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    private lateinit var welcomeText: TextView
    private lateinit var profileButton: Button
    private lateinit var settingsButton: Button
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize views
        welcomeText = findViewById(R.id.welcomeText)
        profileButton = findViewById(R.id.profileButton)
        settingsButton = findViewById(R.id.settingsButton)
        logoutButton = findViewById(R.id.logoutButton)

        // Get user email from intent
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: "المستخدم"
        welcomeText.text = "أهلاً وسهلاً بك،\n$userEmail"

        // Set click listeners
        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_EMAIL", userEmail)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        logoutButton.setOnClickListener {
            handleLogout()
        }
    }

    private fun handleLogout() {
        Toast.makeText(this, "تم تسجيل الخروج", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
