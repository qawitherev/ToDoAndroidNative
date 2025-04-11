/**
 * Todo data class representing a task in the to-do list.
 */

package com.example.todo.data.model

import java.util.Date
import java.util.UUID

data class Todo(
    val id: String = UUID.randomUUID().toString(), 
    val title: String,
    val description: String,
    val isCompleted: Boolean = false,
    val createdAt: Date = Date(),
    val completedAt: Date = Date(),
)