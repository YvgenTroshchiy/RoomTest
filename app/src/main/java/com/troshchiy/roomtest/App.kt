package com.troshchiy.roomtest

import android.app.Application


class App : Application() {

    private val tag = App::class.java.simpleName

    companion object {
        lateinit var APP: App
//        lateinit var database: AppDatabase
    }

    init {
        APP = this
//        database = Room.databaseBuilder(APP, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}