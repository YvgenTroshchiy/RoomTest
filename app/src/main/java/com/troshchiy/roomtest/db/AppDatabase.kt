package com.troshchiy.roomtest.db

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "room_test_db"

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
