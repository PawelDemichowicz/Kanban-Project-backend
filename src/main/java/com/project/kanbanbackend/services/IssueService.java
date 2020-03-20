package com.project.kanbanbackend.services;

import com.project.kanbanbackend.domains.Issue;
import com.project.kanbanbackend.exceptions.IssueNotFoundException;
import com.project.kanbanbackend.exceptions.ProjectNotFoundException;
import com.project.kanbanbackend.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository repository;

    public List<Issue> getIssues(){
        return repository.findAll();
    }

    public Issue getIssue(final Long id){
        return repository.findById(id).orElseThrow(IssueNotFoundException::new);
    }

    public String getDaysLeft(final Long id){
        LocalDate now = LocalDate.now();
        Issue issue =  repository.findById(id).orElseThrow(ProjectNotFoundException::new);
        return Long.toString(ChronoUnit.DAYS.between(now,issue.getFinishDate()));
    }

    public Issue createIssue(final Issue issue){
        return repository.save(issue);
    }

    public void deleteIssue(final Long id){
        repository.deleteById(id);
    }
}
