package com.example.homework19.list

import com.example.homework19.NoteModel
import com.example.homework19.R

class ListNotesRepository {
    fun fetchListNotes(): List<NoteModel> {
        return listOf(
            NoteModel(R.drawable.ic_launcher_background, "Cook"),
            NoteModel(R.drawable.ic_launcher_background, "Homework"),
            NoteModel(R.drawable.ic_launcher_background, "Time"),
            NoteModel(R.drawable.ic_launcher_background, "Happy Birthday"),
            NoteModel(R.drawable.ic_launcher_background, "Phone"))
    }
}