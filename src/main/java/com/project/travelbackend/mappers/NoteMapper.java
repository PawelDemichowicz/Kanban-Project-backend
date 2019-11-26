package com.project.travelbackend.mappers;

import com.project.travelbackend.domains.Note;
import com.project.travelbackend.domains.NoteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public Note mapToNote(final NoteDto noteDto){
        return new Note(
                noteDto.getId(),
                noteDto.getTitle(),
                noteDto.getDescription(),
                noteDto.getCreateDate(),
                noteDto.getProject()
        );
    }

    public NoteDto mapToNoteDto(final Note note){
        return new NoteDto(
                note.getId(),
                note.getTitle(),
                note.getDescription(),
                note.getCreateDate(),
                note.getProject()
        );
    }

    public List<NoteDto> mapToNoteDtoList(final List<Note> notes){
        return notes.stream()
                .map(note -> new NoteDto(note.getId(),note.getTitle(),note.getDescription(),note.getCreateDate(),note.getProject()))
                .collect(Collectors.toList());
    }
}
