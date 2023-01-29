package com.example.jetnotes.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetnotes.data.NoteDataSource
import com.example.jetnotes.model.Note

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()
    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }


    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes():List<Note>{
        return noteList
    }
}