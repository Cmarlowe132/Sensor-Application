package com.example.sensorapplication

import android.hardware.Sensor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorListAdapter() : RecyclerView.Adapter<SensorListAdapter.MyViewHolder>(){

    inner class MyViewHolder(myView: View) : RecyclerView.ViewHolder(myView){
        val sensorName: TextView = myView.findViewById(R.id.sensorName)
        val isSelected: CheckBox = myView.findViewById(R.id.selectionBox)

        fun bindSensorItemViewHolder(sensor: Sensor) {
            sensorName.text = sensor.name
            isSelected.isSelected = InUseSensors.listOfInUseSensors.contains(sensor)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.sensor_container, parent, false)
        return MyViewHolder(myView)
    }

    override fun getItemCount(): Int {
        return SensorList.listOfSensors.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindSensorItemViewHolder(SensorList.listOfSensors[position])
    }

}