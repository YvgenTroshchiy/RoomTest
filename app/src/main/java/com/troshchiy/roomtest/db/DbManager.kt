package com.troshchiy.roomtest.db

import android.util.Log
import androidx.room.Room
import com.troshchiy.roomtest.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private val tag = DbManager::class.java.simpleName

object DbManager {

    private val database = Room.databaseBuilder(App.APP, AppDatabase::class.java, DATABASE_NAME).build()

    fun clearDb() {
        GlobalScope.launch {
            database.userDao().clear()
        }
    }

    fun fillDb() {
        GlobalScope.launch {
            database.userDao().apply {
                insert(User(firstName = "James", lastName = "Smith", age = 35))
                insert(User(firstName = "John", lastName = "Jones", age = 22))
                insert(User(firstName = "Robert", lastName = "Taylor", age = 29))
                insert(User(firstName = "Michael", lastName = "Williams", age = 14))
                insert(User(firstName = "William", lastName = "Brown", age = 28))
                insert(User(firstName = "David", lastName = "Davies", age = 24))
                insert(User(firstName = "Richard", lastName = "Evans", age = 27))
                insert(User(firstName = "Mary", lastName = "Wilson", age = 31))
                insert(User(firstName = "Patricia", lastName = "Thomas", age = 31))
                insert(User(firstName = "Linda", lastName = "Roberts", age = 17))
                insert(User(firstName = "Barbara", lastName = "Johnson", age = 26))
                insert(User(firstName = "Elizabeth", lastName = "Lewis", age = 23))
                insert(User(firstName = "Jennifer", lastName = "Walker", age = 16))
                insert(User(firstName = "Maria", lastName = "Robinson", age = 17))
                insert(User(firstName = "Susan", lastName = "Wood", age = 20))
            }
        }
    }

    fun logDataBase() {
        GlobalScope.launch {
            val allUsers = database.userDao().all

            Log.d(tag, "allUsers.size: ${allUsers.size}")
            Log.d(tag, allUsers.toString())
        }
    }
}
