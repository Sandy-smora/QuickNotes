package com.example.quicknotes

import android.content.SharedPreferences
import android.os.Bundle
import android.content.Context
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.quicknotes.databinding.ActivityMainBinding


class ThridFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "NotePrefs"
    private val KEY_NOTE = "note"

    private lateinit var notesEditText: EditText
    private lateinit var saveNoteButton: Button
    private lateinit var displayNoteButton: Button
    private lateinit var noteTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_thrid, container, false)

        notesEditText = view.findViewById(R.id.noteTextView)
        saveNoteButton = view.findViewById(R.id.saveNoteButton)
        displayNoteButton = view.findViewById(R.id.displayNoteButton)
        noteTextView = view.findViewById(R.id.noteTextView)

        saveNoteButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(KEY_NOTE, notesEditText.text.toString())
            editor.apply()
        }

        displayNoteButton.setOnClickListener {
            val savedNote = sharedPreferences.getString(KEY_NOTE, "No note saved yet.")
            noteTextView.text = savedNote
        }

        return view
    }
}