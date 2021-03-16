package com.example.fundamental

class CuboidModel {
    private var length: Double = 0.0
    private var width: Double = 0.0
    private var height: Double = 0.0

    fun save(length: Double, width: Double, height: Double) {
        this.height = height
        this.length = length
        this.width = width
    }

    fun getSurfaceArea(): Double { return this.length * this.width * this.height * 2 }

    fun getCircumference(): Double { return 4 * (length + width + height)}

    fun getVolume(): Double = length * width * height

}