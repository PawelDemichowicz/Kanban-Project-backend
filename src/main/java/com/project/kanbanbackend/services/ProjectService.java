package com.project.kanbanbackend.services;

import com.project.kanbanbackend.domains.Project;
import com.project.kanbanbackend.exceptions.ProjectNotFoundException;
import com.project.kanbanbackend.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> getProjects(){
        return repository.findAll();
    }

    public Project getProject(final String title){
        return repository.findByTitle(title).orElseThrow(ProjectNotFoundException::new);
    }

    public String getDaysLeft(final Long id){
        LocalDate now = LocalDate.now();
        Project project =  repository.findById(id).orElseThrow(ProjectNotFoundException::new);
        return Long.toString(ChronoUnit.DAYS.between(now,project.getFinishDate()));
    }

    public void createProject(final Project project){
        repository.save(project);
    }

    public void deleteProject(final Long id){
        repository.deleteById(id);
    }
}
