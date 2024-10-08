package com.troshchiy.roomtest.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.troshchiy.roomtest.db.UserScheme.Companion.AGE
import com.troshchiy.roomtest.db.UserScheme.Companion.FIRST_NAME
import com.troshchiy.roomtest.db.UserScheme.Companion.LAST_NAME
import com.troshchiy.roomtest.db.UserScheme.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

class UserScheme {
    companion object {
        const val TABLE_NAME = "user"

        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val AGE = "age"
    }
}

@Entity(tableName = TABLE_NAME) data class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = FIRST_NAME) var firstName: String? = null,
    @ColumnInfo(name = LAST_NAME) var lastName: String? = null,
    @ColumnInfo(name = AGE) var age: Int? = null
)

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
