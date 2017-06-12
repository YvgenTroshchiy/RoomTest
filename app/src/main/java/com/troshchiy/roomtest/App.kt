package com.troshchiy.roomtest

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.troshchiy.roomtest.AppDatabase.Companion.DATABASE_NAME

class App : Application() {

    companion object {
        lateinit var APP: App
        lateinit var DB: RoomDatabase
    }

    init {
        APP = this
        DB = Room.databaseBuilder(applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }
}