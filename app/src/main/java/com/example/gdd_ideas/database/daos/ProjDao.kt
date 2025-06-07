package com.example.gdd_ideas.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gdd_ideas.database.entities.Proj
import kotlinx.coroutines.flow.Flow


@Dao
interface ProjDao {
    @Insert
    fun saveProj(proj: Proj): Long

    @Update
    fun updateProj(proj: Proj): Int

    @Query("DELETE FROM tb_proj")
    fun deleteTable(): Int

    @Query("SELECT * FROM tb_proj")
    fun checkAllTable(): List<Proj>

    @Query("SELECT EXISTS(SELECT * FROM tb_proj WHERE fkUser = :fkUser)")
    fun checkCurUser(fkUser: String): Boolean
}