package com.example.gdd_ideas.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_proj")
data class Proj(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var idProj: Int = 0,

    @ColumnInfo
    var projName: String = "",

    @ColumnInfo
    var projDesc: String = "",

    @ColumnInfo
    var fkUser: String = ""
)

