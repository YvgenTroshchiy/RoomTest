package com.troshchiy.roomtest

import android.app.Application

class App : Application() {

    companion object {
        lateinit var APP: App
    }

    init {
        APP = this
    }

    override fun onCreate() {
        super.onCreate()
    }
}