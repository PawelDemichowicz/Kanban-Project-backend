package com.project.travelbackend.services;

import com.project.travelbackend.domains.Issue;
import com.project.travelbackend.domains.IssueType;
import com.project.travelbackend.domains.Project;
import com.project.travelbackend.repositories.IssueRepository;
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
public class IssueServiceTestSuite {

    @InjectMocks
    IssueService issueService;

    @Mock
    IssueRepository issueRepository;

    @Test
    public void getIssuesTest(){
        //Given
        List<Issue> issues = new ArrayList<>();
        issues.add(new Issue(1L,"AAA","AAAAA",LocalDate.of(2019,1,1),LocalDate.of(2019,1,1), IssueType.TODO,new Project()));
        issues.add(new Issue(2L,"BBB","BBBBB",LocalDate.of(2019,2,2),LocalDate.of(2019,2,2), IssueType.DOING,new Project()));
        issues.add(new Issue(3L,"CCC","CCCCC",LocalDate.of(2019,3,3),LocalDate.of(2019,3,3), IssueType.DONE,new Project()));

        when(issueRepository.findAll()).thenReturn(issues);

        //When
        List<Issue> result = issueService.getIssues();

        //Then
        Assert.assertEquals(3,result.size());
    }

    @Test
    public void getIssueTest(){
        //Given
        Issue issue = new Issue(1L,"AAA","AAAAA",LocalDate.of(2019,1,1),LocalDate.of(2019,1,1), IssueType.TODO,new Project());

        when(issueRepository.findById(issue.getId())).thenReturn(Optional.of(issue));

        //When
        Issue result = issueService.getIssue(issue.getId());

        //Then
        Assert.assertEquals(1,result.getId(),0.001);
        Assert.assertEquals("AAA",result.getTitle());
        Assert.assertEquals("AAAAA",result.getDescription());
    }

    @Test
    public void getDaysLeftTest(){
        //Given
        Issue issue = new Issue(1L,"AAA","AAAAA",LocalDate.of(2019,11,20),LocalDate.of(2019,11,30), IssueType.TODO,new Project());

        when(issueRepository.findById(issue.getId())).thenReturn(Optional.of(issue));

        //When
        String result = issueService.getDaysLeft(issue.getId());

        //Then
        Assert.assertEquals("4", result);
    }

    @Test
    public void createIssueTest(){
        //Given
        Issue issue = new Issue(1L,"AAA","AAAAA",LocalDate.of(2019,11,20),LocalDate.of(2019,11,30), IssueType.TODO,new Project());

        when(issueRepository.save(issue)).thenReturn(issue);

        //When
        Issue result = issueService.createIssue(issue);

        //Then
        Assert.assertEquals(1, result.getId(),0.001);
        Assert.assertEquals("AAA", result.getTitle());
        Assert.assertEquals("AAAAA", result.getDescription());
    }

}
