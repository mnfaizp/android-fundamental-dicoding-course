package com.example.fundamental

import androidx.test.core.app.ActivityScenario
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

@RunWith(AndroidJUnit4ClassRunner::class)
class UnitTestingActivityTest {
    private val dummyVolume: String = "504.0"
    private val dummyCircumference: String = "100.0"
    private val dummySurfaceArea: String = "1008.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "This Field Cannot Empty"

    private fun keyboardView(){
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())
    }

    private fun buttonSave(){
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
    }

    private fun resultReturn(result: String) {
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(result)))
    }

    private fun inputString(viewId: Int){
        onView(withId(viewId)).perform(typeText(emptyInput), closeSoftKeyboard())
    }

    private fun checkError(viewId: Int, dummyFeature: String) {
        onView(withId(viewId)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(viewId)).perform(typeText(dummyFeature), closeSoftKeyboard())
    }

    @Before
    fun setup(){
        ActivityScenario.launch(UnitTestingActivity::class.java)
    }

    @Test
    fun assertGetCircumference() {
        keyboardView()
        buttonSave()

        onView(withId(R.id.btn_count_circumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_count_circumference)).perform(click())

        resultReturn(dummyCircumference)
    }

    @Test
    fun assertGetSurfaceArea(){
        keyboardView()
        buttonSave()

        onView(withId(R.id.btn_count_surface_area)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_count_surface_area)).perform(click())

        resultReturn(dummySurfaceArea)
    }

    @Test
    fun assertGetVolume() {
        keyboardView()
        buttonSave()

        onView(withId(R.id.btn_count_volume)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_count_volume)).perform(click())

        resultReturn(dummyVolume)
    }

    @Test
    fun assertEmptyField() {
        //length check
        inputString(R.id.edt_length)
        buttonSave()
        checkError(R.id.edt_length, dummyLength)

        //width check
        inputString(R.id.edt_width)
        buttonSave()
        checkError(R.id.edt_width, dummyWidth)

        //height check
        inputString(R.id.edt_height)
        buttonSave()
        checkError(R.id.edt_height, dummyHeight)
    }

}