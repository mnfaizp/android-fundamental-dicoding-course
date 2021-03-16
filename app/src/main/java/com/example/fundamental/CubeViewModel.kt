package com.example.fundamental

class CubeViewModel (private val cuboidModel: CuboidModel) {
    fun getCircumference(): Double = cuboidModel.getCircumference()

    fun getVolume(): Double = cuboidModel.getVolume()

    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()

    fun save(l: Double, h:Double, w: Double) {
        cuboidModel.save(l, w, h)
    }
}