package com.alsyd123.pablo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {
    private lateinit var notificationSwitch: Switch
    private lateinit var darkModeSwitch: Switch
    private lateinit var saveButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize views
        notificationSwitch = findViewById(R.id.notificationSwitch)
        darkModeSwitch = findViewById(R.id.darkModeSwitch)
        saveButton = findViewById(R.id.saveButton)
        backButton = findViewById(R.id.backButton)

        // Set click listeners
        saveButton.setOnClickListener {
            val notificationEnabled = notificationSwitch.isChecked
            val darkModeEnabled = darkModeSwitch.isChecked
            Toast.makeText(
                this,
                "تم حفظ الإعدادات\nالإشعارات: $notificationEnabled\nالوضع الليلي: $darkModeEnabled",
                Toast.LENGTH_SHORT
            ).show()
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
