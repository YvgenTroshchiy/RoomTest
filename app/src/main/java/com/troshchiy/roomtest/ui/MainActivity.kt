package com.troshchiy.roomtest.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.troshchiy.roomtest.App.Companion.APP
import com.troshchiy.roomtest.R
import com.troshchiy.roomtest.db.AppDatabase
import com.troshchiy.roomtest.db.User
import org.jetbrains.anko.doAsync


class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {
            val database = AppDatabase.get(APP)
            database.userDao().clear()

            fillDb(database)

            Log.w(tag, "getByLastName: " + database.userDao().getByLastName("Roberts").toString())

            val allUsers = database.userDao().all
            logDataBase(allUsers)
        }
    }

    private fun fillDb(DB: AppDatabase) {
        DB.userDao().apply {
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

    private fun logDataBase(allUsers: List<User>?) {
        Log.w(tag, "allUsers.size: ${allUsers?.size}")
        Log.d(tag, allUsers.toString())
    }
}