package com.example.gdd_ideas.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gdd_ideas.database.entities.Proj
import com.example.gdd_ideas.database.entities.User

@Dao
interface ProjDao {
    @Insert
    fun save(proj: Proj): Long

    @Update
    fun update(proj: Proj): Int

    @Query("SELECT * FROM tb_proj")
    fun checkAllTable(): List<User>

    @Query("SELECT EXISTS(SELECT * FROM tb_proj WHERE email = :email)")
    fun checkExistEmail(email: String): Boolean
}