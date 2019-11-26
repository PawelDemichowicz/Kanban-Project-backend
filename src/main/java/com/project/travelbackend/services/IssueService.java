package com.project.travelbackend.services;

import com.project.travelbackend.domains.Issue;
import com.project.travelbackend.exceptions.IssueNotFoundException;
import com.project.travelbackend.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createIssue(final Issue issue){
        repository.save(issue);
    }

    public void deleteIssue(final Long id){
        repository.deleteById(id);
    }
}
