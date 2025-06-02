package com.example.gdd_ideas.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "tb_user")
data class User(
    @PrimaryKey
    @ColumnInfo
    var id: String = UUID.randomUUID().toString(),

    @ColumnInfo
    var name: String = "",

    @ColumnInfo
    var email: String = "",

    @ColumnInfo
    var password: String = ""
)
