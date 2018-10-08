package com.troshchiy.roomtest.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
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
            val database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
            database.userDao().clear() //Delete
            fillDb(database)

//            database.userDao().insertAll(*arrayOf(user1, user2, user3, user4, user5))
//            database.userDao().deleteByLastName("Ginger")

            val allUsers = database.userDao().all
//            allUsers.obs

            runOnUiThread { logDataBase(allUsers) }

            Log.w(tag, "getByLastName: " + database.userDao().getByLastName("Roberts").toString())
        }
    }

    private fun fillDb(DB: AppDatabase?) {
        DB?.userDao()?.let {
            it.insert(User(firstName = "James", lastName = "Smith", age = 35))
            it.insert(User(firstName = "John", lastName = "Jones", age = 22))
            it.insert(User(firstName = "Robert", lastName = "Taylor", age = 29))
            it.insert(User(firstName = "Michael", lastName = "Williams", age = 14))
            it.insert(User(firstName = "William", lastName = "Brown", age = 28))
            it.insert(User(firstName = "David", lastName = "Davies", age = 24))
            it.insert(User(firstName = "Richard", lastName = "Evans", age = 27))
            it.insert(User(firstName = "Mary", lastName = "Wilson", age = 31))
            it.insert(User(firstName = "Patricia", lastName = "Thomas", age = 31))
            it.insert(User(firstName = "Linda", lastName = "Roberts", age = 17))
            it.insert(User(firstName = "Barbara", lastName = "Johnson", age = 26))
            it.insert(User(firstName = "Elizabeth", lastName = "Lewis", age = 23))
            it.insert(User(firstName = "Jennifer", lastName = "Walker", age = 16))
            it.insert(User(firstName = "Maria", lastName = "Robinson", age = 17))
            it.insert(User(firstName = "Susan", lastName = "Wood", age = 20))
        }
    }

    private fun logDataBase(allUsers: List<User>?) {
        Log.w(tag, "allUsers.size: ${allUsers?.size}")
        Log.d(tag, allUsers.toString())
    }
}