package com.example.sensorapplication

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Arrays.asList
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private lateinit var recordButton: Button

    private lateinit var sensorValueText: TextView
    private lateinit var listOfAvailableSensors: List<Sensor>
    private var sensorValues: MutableList<List<Float>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        listOfAvailableSensors = sensorManager.getSensorList(Sensor.TYPE_ALL)
        SensorList.listOfSensors = listOfAvailableSensors
        InUseSensors.listOfInUseSensors.add(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER))
        recordButton = findViewById(R.id.button)
        val goToSensorSelectionButton: Button = findViewById(R.id.gotoSensorSelection)
        goToSensorSelectionButton.setOnClickListener { _: View ->
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        resetButton()
    }

    private fun beginRecording() {
        recordButton.text = "Record"
        resetButton()


    }

    private fun resetButton() {
        recordButton.setOnClickListener { v: View ->
            recordButton.text = "Stop"
            beginRecording()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            sensorValues.add(listOf(event.values[0], event.values[1],event.values[2]))
            sensorValueText.text=" " + event.values[0] + ", " + event.values[1] + ", " + event.values[2]
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}

