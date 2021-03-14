package com.techyourchance.dagger2course.common.dependencyinjection.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity
) {

    @Provides
    fun activity(): Activity = activity


//    @Provides
//    @ActivityScope
//    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager
}