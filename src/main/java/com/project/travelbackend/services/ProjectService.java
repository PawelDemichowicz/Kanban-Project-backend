package com.project.travelbackend.services;

import com.project.travelbackend.domains.Project;
import com.project.travelbackend.exceptions.ProjectNotFoundException;
import com.project.travelbackend.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createProject(final Project project){
        repository.save(project);
    }

    public void deleteProject(final Long id){
        repository.deleteById(id);
    }
}
