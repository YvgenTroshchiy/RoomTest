package com.troshchiy.roomtest

import android.arch.persistence.room.*

// Kotlin isn't preserving the names of the arguments properly
// this is https://youtrack.jetbrains.com/issue/KT-17959
@Dao interface UserDao {

    @get:Query("SELECT * FROM ${UserSheme.TABLE_NAME}")
    val all: List<User>

    @Query("SELECT * FROM ${UserSheme.TABLE_NAME} WHERE ${UserSheme.LAST_NAME} = :arg0")
    fun getByLastName(lastName: String?): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: User)

    @Delete fun delete(user: User)

    @Query("DELETE FROM ${UserSheme.TABLE_NAME} WHERE ${UserSheme.LAST_NAME} = :arg0")
    fun deleteByLastName(lastName: String?)

    @Query("DELETE FROM ${UserSheme.TABLE_NAME}")
    fun clear()
}