package com.alsyd123.pablo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize views
        profileText = findViewById(R.id.profileText)
        backButton = findViewById(R.id.backButton)

        // Get user email from intent
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: "غير معروف"
        profileText.text = "الملف الشخصي\n\nالبريد الإلكتروني: $userEmail\n\nآخر تحديث: الآن"

        backButton.setOnClickListener {
            finish()
        }
    }
}
