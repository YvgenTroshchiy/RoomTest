package com.troshchiy.roomtest

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "room_test_db"
    }

    abstract fun userDao(): UserDao

}