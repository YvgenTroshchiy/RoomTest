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

        val user1 = User()
        user1.firstName = "Ivan"
        user1.lastName = "Ivanov"

        val user2 = User()
        user2.firstName = "Petr"
        user2.lastName = "Petrov"

        val user3 = User()
        user3.firstName = "Tanya"
        user3.lastName = "Obnimyau"

        val user4 = User()
        user4.firstName = "Cat"
        user4.lastName = "Ginger"

        doAsync {
            //            DB?.userDao()?.insert(user1)
//            DB?.userDao()?.insert(user2)
//            DB?.userDao()?.insert(user3)
//            DB?.userDao()?.insert(user4)

            val users = ArrayList<User>()
            users.add(user1)
            users.add(user2)
            users.add(user3)
            users.add(user4)

//            DB?.userDao()?.insertAll(*arrayOf(user1, user2, user3, user4))
//            DB?.userDao()?.insertAll(*arrayOf(user1, user2, user3, user4))

//            DB?.userDao()?.deleteAll() //Delete
//            DB?.userDao()?.deleteByLastName("Ginger")

            val allUsers = DB?.userDao()?.all

//            runOnUiThread { logDataBase(allUsers) }

            Log.w(TAG, "getByLastName: " + DB?.userDao()?.getByLastName("Ginger").toString())
        }
    }

    private fun logDataBase(allUsers: List<User>?) {
        Log.w(TAG, "allUsers.size: ${allUsers?.size}")
        Log.d(TAG, allUsers.toString())
    }
}