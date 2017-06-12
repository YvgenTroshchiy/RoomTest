package com.troshchiy.roomtest

import android.arch.persistence.room.*
import com.troshchiy.roomtest.User.Companion.USERS_TABLE_NAME

@Dao interface UserDao {

    @get:Query("SELECT * FROM " + USERS_TABLE_NAME)
    val all: List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: User)

    @Delete fun delete(user: User)

    @Query("DELETE FROM " + USERS_TABLE_NAME)
    fun deleteAll()

}