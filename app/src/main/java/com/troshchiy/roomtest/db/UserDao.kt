package com.troshchiy.roomtest.db

import androidx.room.*

@Dao interface UserDao {

    @get:Query("SELECT * FROM ${UserScheme.TABLE_NAME}")
    val all: List<User>

    @Query("SELECT * FROM ${UserScheme.TABLE_NAME} WHERE ${UserScheme.LAST_NAME} = :lastName")
    fun getByLastName(lastName: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: User)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteUsers(vararg users: User)

    @Query("DELETE FROM ${UserScheme.TABLE_NAME} WHERE ${UserScheme.LAST_NAME} = :lastName")
    fun deleteByLastName(lastName: String)

    @Query("DELETE FROM ${UserScheme.TABLE_NAME}")
    fun clear()

}
