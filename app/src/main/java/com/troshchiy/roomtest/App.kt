package com.troshchiy.roomtest

import android.app.Application

class App : Application() {
    private val TAG = App::class.java.simpleName

    companion object {
        lateinit var APP: App
//        lateinit var DB: AppDatabase
//        var DB: AppDatabase? = null
    }

    init {
        APP = this
//        DB = Room.databaseBuilder(applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }

    override fun onCreate() {
        super.onCreate()

//        try {
//            DB = Room.databaseBuilder(applicationContext, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
//        } catch (e: Exception) {
//            Log.w(TAG, "DB", e)
//        }
    }
}