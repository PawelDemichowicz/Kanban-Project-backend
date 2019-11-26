package com.project.travelbackend.services;

import com.project.travelbackend.domains.Issue;
import com.project.travelbackend.domains.Note;
import com.project.travelbackend.exceptions.NoteNotFoundException;
import com.project.travelbackend.repositories.NoteRepository;
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
