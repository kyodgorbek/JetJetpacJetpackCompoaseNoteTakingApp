package com.example.jetnotes.data

import com.example.jetnotes.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A Good day", description = "We went on a vocation by lake"),
            Note(
                title = "Android Compose",
                description = "Working on Android Compose Course Today"
            ),
            Note(title = "Keep at it", description = "Sometimes things just happen"),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents "),
            Note(title = "a Movie Day", description = "Watching Movie with parents ")
        )
    }
}