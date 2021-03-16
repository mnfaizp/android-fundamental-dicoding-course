package com.example.fundamental

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock

class CubeViewModelTest {

    private lateinit var cubeViewModel: CubeViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 500.0

    @Before
    fun before(){
        cuboidModel = mock(CuboidModel::class.java)
        cubeViewModel = CubeViewModel(cuboidModel)
    }


    @Test
    fun getCircumference() {
    }

    @Test
    fun getVolume() {
        cubeViewModel.save(dummyLength, dummyHeight, dummyWidth)

        val volume = cubeViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.00001)
    }

    @Test
    fun getSurfaceArea() {
    }

    @Test
    fun save() {
    }
}