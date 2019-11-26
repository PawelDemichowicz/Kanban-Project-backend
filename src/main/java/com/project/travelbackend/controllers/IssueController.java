package com.project.travelbackend.controllers;

import com.project.travelbackend.domains.Issue;
import com.project.travelbackend.domains.IssueDto;
import com.project.travelbackend.mappers.IssueMapper;
import com.project.travelbackend.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1")
public class IssueController {

    @Autowired
    IssueService service;

    @Autowired
    IssueMapper mapper;

    @GetMapping(value = "/issues")
    public List<IssueDto> getIssues(){
        return mapper.mapToIssueDtoList(service.getIssues());
    }

    @GetMapping(value = "/issue")
    public IssueDto getIssue(@RequestParam Long id){
        return mapper.mapToIssueDto(service.getIssue(id));
    }

    @PostMapping(value = "/issue", consumes = APPLICATION_JSON_VALUE)
    public void createIssue(@RequestBody IssueDto issueDto){
        service.createIssue(mapper.mapToIssue(issueDto));
    }

    @DeleteMapping(value = "/issue")
    public void deleteIssue(@RequestParam Long id){
        service.deleteIssue(id);
    }

}
