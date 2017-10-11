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

            DB?.userDao()?.insert(User(firstName = "James", lastName = "Smith"))
            DB?.userDao()?.insert(User(firstName = "John", lastName = "Jones"))
            DB?.userDao()?.insert(User(firstName = "Robert", lastName = "Taylor"))
            DB?.userDao()?.insert(User(firstName = "Michael", lastName = "Williams"))
            DB?.userDao()?.insert(User(firstName = "William", lastName = "Brown"))
            DB?.userDao()?.insert(User(firstName = "David", lastName = "Davies"))
            DB?.userDao()?.insert(User(firstName = "Richard", lastName = "Evans"))
            DB?.userDao()?.insert(User(firstName = "Mary", lastName = "Wilson"))
            DB?.userDao()?.insert(User(firstName = "Patricia", lastName = "Thomas"))
            DB?.userDao()?.insert(User(firstName = "Linda", lastName = "Roberts"))
            DB?.userDao()?.insert(User(firstName = "Barbara", lastName = "Johnson"))
            DB?.userDao()?.insert(User(firstName = "Elizabeth", lastName = "Lewis"))
            DB?.userDao()?.insert(User(firstName = "Jennifer", lastName = "Walker"))
            DB?.userDao()?.insert(User(firstName = "Maria", lastName = "Robinson"))
            DB?.userDao()?.insert(User(firstName = "Susan", lastName = "Wood"))

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