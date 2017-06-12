package com.troshchiy.roomtest

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.troshchiy.roomtest.User.Companion.USERS_TABLE_NAME

@Entity(tableName = USERS_TABLE_NAME) class User {

    companion object {
        const val USERS_TABLE_NAME = "users"
    }

    @PrimaryKey(autoGenerate = true) var id: Int = 0
    @ColumnInfo(name = "first_name") var firstName: String? = null
    @ColumnInfo(name = "last_name") var lastName: String? = null

    override fun toString(): String {
        return "User(id: $id, firstName: $firstName, lastName: $lastName)"
    }
}