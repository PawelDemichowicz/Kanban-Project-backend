package com.project.travelbackend.controllers;

import com.project.travelbackend.domains.ProjectDto;
import com.project.travelbackend.mappers.ProjectMapper;
import com.project.travelbackend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1")
public class ProjectController {

    @Autowired
    ProjectService service;

    @Autowired
    ProjectMapper mapper;

    @GetMapping(value = "/projects")
    public List<ProjectDto> getProjects(){
        return mapper.mapToProjectDtoList(service.getProjects());
    }

    @GetMapping(value = "/project")
    public ProjectDto getProject(@RequestParam String title){
        return mapper.mapToProjectDto(service.getProject(title));
    }

    @GetMapping(value = "/project/daysLeft")
    public String getDaysLeft(@RequestParam Long id){
        return service.getDaysLeft(id);
    }

    @PostMapping(value = "/project", consumes = APPLICATION_JSON_VALUE)
    public void createProject(@RequestBody ProjectDto projectDto){
        service.createProject(mapper.mapToProject(projectDto));
    }

    @DeleteMapping(value = "/project")
    public void deleteProject(@RequestParam Long id){
        service.deleteProject(id);
    }
}
