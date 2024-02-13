package com.example.homework19.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListNotesFactory(
    private val repository: ListNotesRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListNotesViewModel::class.java))
            return ListNotesViewModel(repository) as T
        throw IllegalArgumentException("Unknown model")
    }
}