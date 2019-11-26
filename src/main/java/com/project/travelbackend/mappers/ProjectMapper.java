package com.project.travelbackend.mappers;

import com.project.travelbackend.domains.Project;
import com.project.travelbackend.domains.ProjectDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    public Project mapToProject(final ProjectDto projectDto){
        return new Project(
                projectDto.getId(),
                projectDto.getTitle(),
                projectDto.getDescription(),
                projectDto.getCreateDate(),
                projectDto.getFinishDate(),
                projectDto.getIssues(),
                projectDto.getNotes()

        );
    }

    public ProjectDto mapToProjectDto(final Project project){
        return new ProjectDto(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getCreateDate(),
                project.getFinishDate(),
                project.getIssues(),
                project.getNotes()
        );
    }

    public List<ProjectDto> mapToProjectDtoList(final List<Project> projectList){
        return projectList.stream()
                .map(project -> new ProjectDto(project.getId(),project.getTitle(),project.getDescription(),
                        project.getCreateDate(),project.getFinishDate(),project.getIssues(),project.getNotes()))
                .collect(Collectors.toList());
    }
}
