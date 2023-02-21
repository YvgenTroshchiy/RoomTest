package com.troshchiy.roomtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    private val tag = App::class.java.simpleName

    companion object {
        lateinit var APP: App
    }

    init {
        APP = this
    }
}
