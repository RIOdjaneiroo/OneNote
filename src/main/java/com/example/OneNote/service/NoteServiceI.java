package com.example.OneNote.service;

import com.example.OneNote.entity.Note;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class NoteServiceI implements NoteService{

    @Autowired
    private NoteFakeRepositortry noteFakeRepositortry;
    @Override
    public List<Note> listAll() {
        return noteFakeRepositortry.findAllNotes();
    }

    @Override
    public Note add(Note note) {
        return noteFakeRepositortry.createNote(note);
    }

    @Override
    public void deleteById(UUID id) {
        String deletedMessage = noteFakeRepositortry.deleteNoteById(id);
        log.info(deletedMessage);
    }
    @Override
    public void update(Note updatedNote) {
        String updatedMessage = noteFakeRepositortry.updateNote(updatedNote);
        log.info(updatedMessage);
    }

    @Override
    public Note getById(UUID id) {
        return noteFakeRepositortry.getNoteById(id);
    }

    @PostConstruct
    public void init(){
        Note n = new Note();
        n.setTitle("title");
        n.setContent("content");
        n.setCreationTime(LocalDateTime.now());
        add(n);
        log.info("nnotes= " + listAll() );

        Note m = new Note();
        m.setTitle("title2");
        m.setContent("HALLO");
        m.setCreationTime(LocalDateTime.now());
        add(m);
        log.info("mnotes = "+ listAll());


//          // видаляємо нотатку n
//        deleteById(n.getId());
////        deleteById(UUID.randomUUID());
//        log.info("note= " + listAll());


        // оновлюємо нотатку n
        n.setTitle("Updated Title");
        n.setContent("Updated Content");
//        n.setId(UUID.randomUUID());
        update(n);
        log.info("Updated nnotes= " + listAll());
    }
}
