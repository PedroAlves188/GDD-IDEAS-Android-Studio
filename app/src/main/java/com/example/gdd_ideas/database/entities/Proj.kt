package com.example.gdd_ideas.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "tb_proj")
data class Proj(
    @PrimaryKey
    var idProj: String = UUID.randomUUID().toString(),

    var projName: String = "",

    var projDesc: String = "",

    var fkUser: String = ""
)
