package com.example.jetnotes.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnotes.model.Note
import com.example.jetnotes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    // private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        // noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes()
                .distinctUntilChanged()
                .collect { notes ->
                    if (notes.isNullOrEmpty()) {
                        Log.d("NOTEVIEWMODEL", "note list is empty!!!")
                    }
                    _noteList.value = notes
                }
        }
    }


    fun addNote(note: Note) = viewModelScope.launch { noteRepository.addNote(note) }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)

    }

    fun removeNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }


}