package com.troshchiy.roomtest

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase

class App : Application() {

    companion object {
        lateinit var APP: App
        lateinit var DB: RoomDatabase
    }

    init {
        APP = this
        DB = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "room_test_database").build()
    }
}