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

        fun bindSensorItemViewHolder(sensorItem: SensorItem) {
            sensorName.text = sensorItem.sensor.name
            isSelected.setOnCheckedChangeListener(null)
            isSelected.isSelected = sensorItem.isSelected

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
        holder.sensorName.text = SensorList.listOfSensors[position].sensor.name
        holder.isSelected.setOnCheckedChangeListener(null)
        holder.isSelected.setChecked(SensorList.listOfSensors[position].isSelected)
        holder.isSelected.setOnCheckedChangeListener { buttonview, isChecked ->
            SensorList.listOfSensors[position].isSelected = isChecked
        }

    //holder.bindSensorItemViewHolder(SensorList.listOfSensors[position])
    }

}