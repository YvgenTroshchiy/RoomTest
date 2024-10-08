package com.troshchiy.roomtest.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.troshchiy.roomtest.db.DogScheme.Companion.AGE
import com.troshchiy.roomtest.db.DogScheme.Companion.BREED
import com.troshchiy.roomtest.db.DogScheme.Companion.NAME
import com.troshchiy.roomtest.db.DogScheme.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

class DogScheme {
    companion object {
        const val TABLE_NAME = "dog"

        const val NAME = "first_name"
        const val BREED = "breed"
        const val AGE = "age"
    }
}

@Entity(tableName = TABLE_NAME) data class Dog(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = NAME) var name: String? = null,
    @ColumnInfo(name = BREED) var breed: String? = null,
    @ColumnInfo(name = AGE) var age: Int? = null
)

@Dao
interface DogDao {

    @get:Query("SELECT * FROM dog")
    val all: Flow<List<Dog>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg dog: Dog)

    @Query("DELETE FROM dog")
    fun clear()
}
