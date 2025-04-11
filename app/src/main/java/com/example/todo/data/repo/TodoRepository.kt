/**
 * TodoRepository.kt
 * This file serves as the repository for the TodoEntity data model.
 * Will be used inside viewModel
 */

package com.example.todo.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.todo.data.model.Todo
import com.example.todo.data.model.TodoDao
import com.example.todo.data.model.TodoEntity

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos().map { theList -> 
        theList.map {it.toTodo()}
    }

    suspend fun getTodoById(id: String): Todo? {
        return todoDao.getTodoById(id)?.toTodo()
    }   

    suspend fun insert(todo: Todo) {
        todoDao.insertTodo(TodoEntity.fromTodo(todo))
    }

    suspend fun update(todo: Todo) {
        todoDao.updateTodo(TodoEntity.fromTodo(todo))
    }

    suspend fun delete(todo: Todo) {
        todoDao.deleteTodo(TodoEntity.fromTodo(todo))
    }

    suspend fun deleteAll() {
        todoDao.deleteAllTodos()
    }
}