/**
 * TodoDao.kt
 * This file serves as data access object (DAO) in room
 * for the TodoEntity data model.
 */

package com.example.todo.data.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo ORDER BY createdAt DESC")
    fun getAllTodos(): LiveData<List<TodoEntity>>

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id: String): TodoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Query("DELETE FROM todo")
    suspend fun deleteAllTodos()
}