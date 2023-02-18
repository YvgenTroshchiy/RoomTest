package com.troshchiy.roomtest.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.troshchiy.roomtest.db.UserScheme.Companion.AGE
import com.troshchiy.roomtest.db.UserScheme.Companion.FIRST_NAME
import com.troshchiy.roomtest.db.UserScheme.Companion.LAST_NAME
import com.troshchiy.roomtest.db.UserScheme.Companion.TABLE_NAME

class UserScheme {
    companion object {
        const val TABLE_NAME = "user"

        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val AGE = "age"
    }
}

@Entity(tableName = TABLE_NAME) data class User(
    @PrimaryKey(autoGenerate = true) var _id: Int = 0,
    @ColumnInfo(name = FIRST_NAME) var firstName: String? = null,
    @ColumnInfo(name = LAST_NAME) var lastName: String? = null,
    @ColumnInfo(name = AGE) var age: Int? = null
)
