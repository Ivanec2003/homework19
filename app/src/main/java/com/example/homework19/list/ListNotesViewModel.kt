package com.example.homework19.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework19.NoteModel

class ListNotesViewModel(
    private val repository: ListNotesRepository
):ViewModel() {
    private val _listNotes = MutableLiveData<List<NoteModel>>()
    val listNotes: LiveData<List<NoteModel>>
        get() = _listNotes

    fun fetchListNotes(){
        val result = repository.fetchListNotes()
        _listNotes.value = result
    }
}