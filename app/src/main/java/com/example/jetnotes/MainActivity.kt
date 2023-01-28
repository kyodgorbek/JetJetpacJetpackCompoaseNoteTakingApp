package com.example.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnotes.data.NoteDataSource
import com.example.jetnotes.model.Note
import com.example.jetnotes.screen.NoteScreen
import com.example.jetnotes.ui.theme.JetNotesTheme
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    color = MaterialTheme.colors.background) {
                    NoteScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
                }
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked:(Note) -> Unit
){
Surface(
    modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
    color = Color(0xFFDFE6EB),
    elevation = 6.dp){
    Column(
        modifier
            .clickable {}
            .padding(horizontal = 14.dp, vertical = 6.dp),
    horizontalAlignment = Alignment.Start) {
        Text(text = note.title,
             style = MaterialTheme.typography.subtitle2)
        Text(text = note.description,
            style = MaterialTheme.typography.subtitle1)
        Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
        style = MaterialTheme.typography.caption)

    }

    }


}

