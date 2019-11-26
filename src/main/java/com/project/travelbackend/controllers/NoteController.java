package com.project.travelbackend.controllers;

import com.project.travelbackend.domains.Note;
import com.project.travelbackend.domains.NoteDto;
import com.project.travelbackend.mappers.NoteMapper;
import com.project.travelbackend.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1")
public class NoteController {

    @Autowired
    NoteService service;

    @Autowired
    NoteMapper mapper;

    @GetMapping(value = "/notes")
    public List<NoteDto> getNotes(){
        return mapper.mapToNoteDtoList(service.getNotes());
    }

    @GetMapping(value = "/note")
    public NoteDto getNote(@RequestParam Long id){
        return mapper.mapToNoteDto(service.getNote(id));
    }

    @PostMapping(value = "note", consumes = APPLICATION_JSON_VALUE)
    public void createNote(@RequestBody NoteDto noteDto){
        service.createNote(mapper.mapToNote(noteDto));
    }

    @DeleteMapping(value = "/note")
    public void deleteNote(@RequestParam Long id){
        service.deleteNote(id);
    }
}
