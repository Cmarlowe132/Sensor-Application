package com.example.sensorapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var recordButton: Button
    private lateinit var motionSensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        motionSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if(motionSensor == null) {
            print("Movement Sensor not available")
            return
        }
        recordButton = findViewById(R.id.button)
        recordButton.setOnClickListener { v: View ->
            recordButton.text = "Stop"
            beginRecording()
        }
    }

    private fun beginRecording() {
        motionSensor?.also { motion ->
            sensorManager.registerListener(this, motion, SensorManager.SENSOR_DELAY_NORMAL)
        }
        recordButton.setOnClickListener { v: View ->
            sensorManager.unregisterListener(this)
            recordButton.text = "Record"
            resetButton()

        }

    }

    private fun resetButton() {
        recordButton.setOnClickListener { v: View ->
            recordButton.text = "Stop"
            beginRecording()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}

