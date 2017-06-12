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

            DB?.userDao()?.insert(User(firstName = "Ivan", lastName = "Ivanov"))
            DB?.userDao()?.insert(User(firstName = "Petr", lastName = "Petrov"))
            DB?.userDao()?.insert(User(firstName = "Tanya", lastName = "Tatyanina"))
            DB?.userDao()?.insert(User(firstName = "Cat", lastName = "Ginger"))
            DB?.userDao()?.insert(User(firstName = "Yevhen", lastName = "Troshchii"))

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