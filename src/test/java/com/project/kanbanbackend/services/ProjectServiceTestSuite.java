package com.project.kanbanbackend.services;

import com.project.kanbanbackend.domains.Project;
import com.project.kanbanbackend.repositories.ProjectRepository;
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
public class ProjectServiceTestSuite {

    @InjectMocks
    ProjectService projectService;

    @Mock
    ProjectRepository projectRepository;

    @Test
    public void getProjectsTest(){
        //Given
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L,"AAA","AAAAA", LocalDate.of(2019,1,1),LocalDate.of(2019,1,1),new ArrayList<>(),new ArrayList<>()));
        projects.add(new Project(2L,"BBB","BBBBB", LocalDate.of(2019,2,2),LocalDate.of(2019,2,2),new ArrayList<>(),new ArrayList<>()));
        projects.add(new Project(3L,"CCC","CCCCC", LocalDate.of(2019,3,3),LocalDate.of(2019,3,3),new ArrayList<>(),new ArrayList<>()));

        when(projectRepository.findAll()).thenReturn(projects);

        //When
        List<Project> result = projectService.getProjects();

        //Then
        Assert.assertEquals(3,result.size());
    }

    @Test
    public void getProjectTest(){
        //Given
        Project project = new Project(1L,"AAA","AAAAA", LocalDate.of(2019,1,1),LocalDate.of(2019,1,1),new ArrayList<>(),new ArrayList<>());

        when(projectRepository.findByTitle(project.getTitle())).thenReturn(Optional.of(project));

        //When
        Project result = projectService.getProject(project.getTitle());

        //Then
        Assert.assertEquals(1,result.getId(),0.001);
        Assert.assertEquals("AAA",result.getTitle());
        Assert.assertEquals("AAAAA",result.getDescription());
    }

    @Test
    public void getDaysLeftTest(){
        //Given
        Project project = new Project(1L,"AAA","AAAAA", LocalDate.of(2019,1,1),LocalDate.of(2019,11,27),new ArrayList<>(),new ArrayList<>());

        when(projectRepository.findById(project.getId())).thenReturn(Optional.of(project));

        //When
        String result = projectService.getDaysLeft(project.getId());

        //Then
        Assert.assertEquals("1", result);
    }
}
