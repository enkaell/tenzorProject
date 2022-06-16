package com.example.tenzorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.Button)
        button.setOnClickListener{
            val app_intent = Intent(this, appActivity::class.java)
            startActivity(app_intent)
        }
    }
}