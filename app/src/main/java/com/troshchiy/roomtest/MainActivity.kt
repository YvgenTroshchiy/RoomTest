package com.troshchiy.roomtest

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var DB: AppDatabase? = null
        try {
            DB = Room.databaseBuilder(applicationContext, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
        } catch (e: Exception) {
            Log.w(TAG, "DB", e)
        }

        doAsync {
            DB?.userDao()?.clear() //Delete

            DB?.userDao()?.insert(User(firstName = "James", lastName = "Smith", age = 35))
            DB?.userDao()?.insert(User(firstName = "John", lastName = "Jones", age = 22))
            DB?.userDao()?.insert(User(firstName = "Robert", lastName = "Taylor", age = 29))
            DB?.userDao()?.insert(User(firstName = "Michael", lastName = "Williams", age = 14))
            DB?.userDao()?.insert(User(firstName = "William", lastName = "Brown", age = 28))
            DB?.userDao()?.insert(User(firstName = "David", lastName = "Davies", age = 24))
            DB?.userDao()?.insert(User(firstName = "Richard", lastName = "Evans", age = 27))
            DB?.userDao()?.insert(User(firstName = "Mary", lastName = "Wilson", age = 31))
            DB?.userDao()?.insert(User(firstName = "Patricia", lastName = "Thomas", age = 31))
            DB?.userDao()?.insert(User(firstName = "Linda", lastName = "Roberts", age = 17))
            DB?.userDao()?.insert(User(firstName = "Barbara", lastName = "Johnson", age = 26))
            DB?.userDao()?.insert(User(firstName = "Elizabeth", lastName = "Lewis", age = 23))
            DB?.userDao()?.insert(User(firstName = "Jennifer", lastName = "Walker", age = 16))
            DB?.userDao()?.insert(User(firstName = "Maria", lastName = "Robinson", age = 17))
            DB?.userDao()?.insert(User(firstName = "Susan", lastName = "Wood", age = 20))

            val users = ArrayList<User>()
//            DB?.userDao()?.insertAll(*arrayOf(user1, user2, user3, user4, user5))

//            DB?.userDao()?.deleteByLastName("Ginger")

            val allUsers = DB?.userDao()?.all

            runOnUiThread { logDataBase(allUsers) }

            Log.w(TAG, "getByLastName: " + DB?.userDao()?.getByLastName("Ginger").toString())
        }
    }

    private fun logDataBase(allUsers: List<User>?) {
        Log.w(TAG, "allUsers.size: ${allUsers?.size}")
        Log.d(TAG, allUsers.toString())
    }
}