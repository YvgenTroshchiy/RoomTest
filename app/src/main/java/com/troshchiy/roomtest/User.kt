package com.troshchiy.roomtest

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity class User() {
    @PrimaryKey(autoGenerate = true) public var id: Int = 0
    @ColumnInfo(name = "first_name") public var firstName: String? = null
    @ColumnInfo(name = "last_name") public var lastName: String? = null

    override fun toString(): String {
        return "User(id=$id, firstName=$firstName, lastName=$lastName)"
    }
}