package com.project.kanbanbackend.repositories;

import com.project.kanbanbackend.domains.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface NoteRepository extends CrudRepository<Note,Long> {

    @Override
    List<Note> findAll();

    @Override
    Note save (Note note);

    @Override
    Optional<Note> findById(Long id);

    @Override
    void deleteById(Long id);
}
