package com.example.gdd_ideas.database.daos

import android.R
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

import com.example.gdd_ideas.database.entities.User

@Dao
interface UserDao {
    @Insert
    fun save(user: User): Long

    @Update
    fun update(user: User): Int

    @Query("SELECT * FROM tb_user")
    fun checkAllTable(): List<User>

    @Query("SELECT EXISTS (SELECT * FROM tb_user WHERE (name = :userId OR email = :userId) AND password = :passId)")
    fun checkLogin(userId: String, passId: String): Boolean

    @Query("SELECT EXISTS(SELECT * FROM tb_user WHERE email = :email)")
    fun checkExistEmail(email: String): Boolean
}