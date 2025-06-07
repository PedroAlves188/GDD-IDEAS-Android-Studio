package com.example.gdd_ideas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gdd_ideas.database.daos.ProjDao
import com.example.gdd_ideas.database.daos.UserDao
import com.example.gdd_ideas.database.entities.Proj
import com.example.gdd_ideas.database.entities.User

@Database(entities = [User::class, Proj::class], version = 1, exportSchema = false)
abstract class MyDataBase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getProjDao(): ProjDao

    companion object {
        private lateinit var INSTANCE: MyDataBase

        fun getDatabase(context: Context): MyDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(MyDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, MyDataBase::class.java, "db_user")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}