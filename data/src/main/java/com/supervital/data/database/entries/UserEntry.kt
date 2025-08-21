package com.supervital.data.database.entries

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntry (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var id: Int,
    @ColumnInfo(name = "userName")
    var name: String,
    var age: Int
)
