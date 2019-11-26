package com.project.travelbackend.services;

import com.project.travelbackend.domains.Note;
import com.project.travelbackend.domains.Project;
import com.project.travelbackend.repositories.NoteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTestSuite {

    @InjectMocks
    NoteService noteService;

    @Mock
    NoteRepository noteRepository;

    @Test
    public void getNotesTest(){
        //Given
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1L,"AAA","AAAAA", LocalDate.of(2019,1,1),new Project()));
        notes.add(new Note(2L,"BBB","BBBBB",LocalDate.of(2019,2,2),new Project()));
        notes.add(new Note(3L,"CCC","CCCCC",LocalDate.of(2019,3,3),new Project()));

        when(noteRepository.findAll()).thenReturn(notes);

        //When
        List<Note> result = noteService.getNotes();

        //Then
        Assert.assertEquals(3,result.size());
    }

    @Test
    public void getNoteTest(){
        //Given
        Note note = new Note(1L,"AAA","AAAAA", LocalDate.of(2019,1,1),new Project());

        when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));

        //When
        Note result = noteService.getNote(note.getId());

        //Then
        Assert.assertEquals(1,result.getId(),0.001);
        Assert.assertEquals("AAA",result.getTitle());
        Assert.assertEquals("AAAAA",result.getDescription());
    }

    @Test
    public void createNoteTest(){
        //Given
        Note note = new Note(1L,"AAA","AAAAA", LocalDate.of(2019,1,1),new Project());

        when(noteRepository.save(note)).thenReturn(note);

        //When
        Note result = noteService.createNote(note);

        //Then
        Assert.assertEquals(1, result.getId(),0.001);
        Assert.assertEquals("AAA", result.getTitle());
        Assert.assertEquals("AAAAA", result.getDescription());
    }
}
