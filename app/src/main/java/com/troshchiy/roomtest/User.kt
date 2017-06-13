package com.troshchiy.roomtest

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.troshchiy.roomtest.UserSheme.Companion.FIRST_NAME
import com.troshchiy.roomtest.UserSheme.Companion.LAST_NAME
import com.troshchiy.roomtest.UserSheme.Companion.TABLE_NAME

//@PaperParcel
@Entity(tableName = TABLE_NAME) data class User(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @ColumnInfo(name = FIRST_NAME) var firstName: String? = null,
        @ColumnInfo(name = LAST_NAME) var lastName: String? = null)
//    : PaperParcelable {
//    companion object {
//        @JvmField val CREATOR = PaperParcelUser.CREATOR
//    }
//}

class UserSheme {
    companion object {
        const val TABLE_NAME = "users"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
    }
}