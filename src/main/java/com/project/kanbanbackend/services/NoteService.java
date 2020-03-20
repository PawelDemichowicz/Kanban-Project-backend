package com.project.kanbanbackend.services;

import com.project.kanbanbackend.domains.Note;
import com.project.kanbanbackend.exceptions.NoteNotFoundException;
import com.project.kanbanbackend.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public List<Note> getNotes(){
        return repository.findAll();
    }

    public Note getNote(final Long id){
        return repository.findById(id).orElseThrow(NoteNotFoundException::new);
    }

    public Note createNote(final Note note){
        return repository.save(note);
    }

    public void deleteNote(final Long id){
        repository.deleteById(id);
    }
}
