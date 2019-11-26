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
    ProjectService serivce;

    @Autowired
    ProjectMapper mapper;

    @GetMapping(value = "/projects")
    public List<ProjectDto> getProjects(){
        return mapper.mapToProjectDtoList(serivce.getProjects());
    }

    @GetMapping(value = "/project")
    public ProjectDto getProject(@RequestParam String title){
        return mapper.mapToProjectDto(serivce.getProject(title));
    }

    @PostMapping(value = "/project", consumes = APPLICATION_JSON_VALUE)
    public void createProject(@RequestBody ProjectDto projectDto){
        serivce.createProject(mapper.mapToProject(projectDto));
    }

    @DeleteMapping(value = "/project")
    public void deleteProject(@RequestParam Long id){
        serivce.deleteProject(id);
    }
}
