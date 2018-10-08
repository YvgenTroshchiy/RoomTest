package com.troshchiy.roomtest.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "room_test_db"
    }

    abstract fun userDao(): UserDao

}