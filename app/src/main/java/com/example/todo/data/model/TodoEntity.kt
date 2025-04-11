/**
 * TodoEntity.kt
 * This file serves as data model entity in room 
 * for DAO, kindly see TodoDao.kt
 * 
 */

 package com.example.todo.data.model

 import androidx.room.Entity
 import androidx.room.PrimaryKey
 import java.util.Date

 @Entity(tableName = "todo")
 data class TodoEntity(
    @PrimaryKey val id: String, 
    val title: String, 
    val description: String, 
    val isCompleted: Boolean,
    val createdAt: Long, 
    val completedAt: Long
 ) {
    fun toTodo(): Todo {
        return Todo(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            createdAt = Date(createdAt),
            completedAt = Date(completedAt)
        )
    }

    companion object {
        fun fromTodo(todo: Todo): TodoEntity {
            return TodoEntity(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                isCompleted = todo.isCompleted,
                createdAt = todo.createdAt.time,
                completedAt = todo.completedAt.time
            )
        }
    }
 }