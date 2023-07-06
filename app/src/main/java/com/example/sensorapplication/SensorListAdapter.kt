package com.example.sensorapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SensorListAdapter() : RecyclerView.Adapter<SensorListAdapter.myViewHolder>(){

    inner class myViewHolder(myView: View) : RecyclerView.ViewHolder(myView){
        val sensorName: TextView = myView.findViewById(R.id.sensorName)
        val isSelected: CheckBox = myView.findViewById(R.id.selectionBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.sensor_container, parent, false)
        return myViewHolder(myView)
    }

    override fun getItemCount(): Int {
        return SensorList.listOfSensors.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.sensorName.text = SensorList.listOfSensors[position].name
        holder.isSelected.isSelected = InUseSensors.listOfInUseSensors.contains(SensorList.listOfSensors[position])
    }

}