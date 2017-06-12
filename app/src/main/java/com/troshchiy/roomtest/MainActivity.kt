package com.troshchiy.roomtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.troshchiy.roomtest.App.Companion.DB

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        DB?.userDao()?.insert(user1)
        DB?.userDao()?.insert(user2)
        DB?.userDao()?.insert(user3)
        DB?.userDao()?.insert(user4)

        DB?.setTransactionSuccessful()
        DB?.endTransaction()

        val users = ArrayList<User>()
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)

//        DB?.userDao()?.insertAll(users)
//        DB?.setTransactionSuccessful()

        val allUsers = DB?.userDao()?.all
        val o = 0

        Log.d(TAG, allUsers.toString())
    }
}