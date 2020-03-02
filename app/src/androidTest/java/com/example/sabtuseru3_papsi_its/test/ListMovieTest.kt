package com.example.sabtuseru3_papsi_its.test

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sabtuseru3_papsi_its.R
import com.example.sabtuseru3_papsi_its.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListMovieTest {

    private val milis: Long = 3000

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testMovieBehaviour(){

        Thread.sleep(milis)

        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

        Thread.sleep(milis)

        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3)
        )

        Thread.sleep(milis)

        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click())
        )

        Thread.sleep(milis)

        onView(withId(R.id.layout_detail_movie)).check(matches(isDisplayed()))

        Thread.sleep(milis)

        Espresso.pressBack()
    }
}