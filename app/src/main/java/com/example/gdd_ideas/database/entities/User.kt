package com.example.gdd_ideas.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "tb_user")
data class User(
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),

    var name: String = "",

    var email: String = "",

    var password: String = ""
)
