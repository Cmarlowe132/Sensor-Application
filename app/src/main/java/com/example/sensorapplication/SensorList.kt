package com.example.sensorapplication

import android.hardware.Sensor

object SensorList {
    public var listOfSensors: MutableList<SensorItem> = arrayListOf()

    public fun add(item: SensorItem) {
        listOfSensors.add(item)
    }

    public fun generateList(list: List<Sensor>) {
        for(i in list.indices) {
            listOfSensors.add(SensorItem(list[i],false))
        }
    }
}