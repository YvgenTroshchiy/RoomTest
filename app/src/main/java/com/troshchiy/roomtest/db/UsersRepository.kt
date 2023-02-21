package com.troshchiy.roomtest.db

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private val tag = UsersRepositoryImpl::class.java.simpleName

interface UsersRepository {
    suspend fun fillDb() {}
    suspend fun clearDb() {}
    fun getUsers(): Flow<List<User>>
    suspend fun logDataBase() {}
}

class UsersRepositoryImpl @Inject constructor(private val database: AppDatabase) : UsersRepository {

    override suspend fun fillDb() {
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

    override suspend fun clearDb() {
        database.userDao().clear()
    }

    override fun getUsers(): Flow<List<User>> {
        return database.userDao().all
    }

    override suspend fun logDataBase() {
        val allUsers = database.userDao().all

//        Log.d(tag, "allUsers.size: ${allUsers.size}")
//        Log.d(tag, allUsers.toString())
    }
}
