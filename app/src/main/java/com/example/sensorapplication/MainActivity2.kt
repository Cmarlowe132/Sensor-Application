package com.example.sensorapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_sensors)

        val rv: RecyclerView = findViewById(R.id.listOfSensors)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = SensorListAdapter()

        val acceptButton: Button = findViewById(R.id.acceptButton)
        acceptButton.setOnClickListener { v: View ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}