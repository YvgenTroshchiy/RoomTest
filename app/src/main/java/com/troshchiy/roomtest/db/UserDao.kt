package com.troshchiy.roomtest.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @get:Query("SELECT * FROM user")
    val all: Flow<List<User>>

    @Query("SELECT * FROM user WHERE last_name = :lastName")
    fun getByLastName(lastName: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: User)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteUsers(vararg users: User)

    @Query("DELETE FROM user WHERE last_name = :lastName")
    fun deleteByLastName(lastName: String)

    @Query("DELETE FROM user")
    fun clear()

}
