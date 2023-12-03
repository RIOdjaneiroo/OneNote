package com.example.OneNote.service;

import com.example.OneNote.entity.Note;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Service
public class NoteFakeRepositortry {
    private List<Note> notes = new ArrayList<>();

    public Note createNote (Note note){
        note.setId(UUID.randomUUID());
        this.notes.add(note);
        return note;
    }
    public List<Note> findAllNotes (){
        return this.notes;
    }
    public String deleteNoteById(UUID id){
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId().equals(id)) {
                iterator.remove();
                return "Note "+note+" deleted successfully";
            }
        }
        return "Note with id "+id+" not found";
    }
    public String updateNote(Note note) {
        //UUID id = UUID.randomUUID();
        UUID id = note.getId();
        for (Note unotes : notes) {
            if (note.getId().equals(id)) {
                note.setTitle(note.getTitle());
                note.setContent(note.getContent());
                note.setCreationTime(LocalDateTime.now());
                return "Update Note = "+note+" updated successfully";
            }
        }
        return "Note with id "+id+" not found";
    }
    public Note getNoteById(UUID id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        throw new RuntimeException("Note with id " + id + " not found");
    }
}
