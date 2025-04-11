/**
 * TodoDatabase.kt
 * create a singleton database class for the TodoEntity data model
 * this class will be used to create the database and provide access to the DAO
 * it will also handle the database version and migration if needed in the future
 */

package com.example.todo.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false) 
abstract class TodoDatabase: RoomDatabase() {
        abstract fun todoDao(): TodoDao

        companion object {
            @Volatile 
            private var INSTANCE: TodoDatabase? = null 

            fun getDatabase(context: Context): TodoDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext, 
                        TodoDatabase::class.java, 
                        "todo_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
}