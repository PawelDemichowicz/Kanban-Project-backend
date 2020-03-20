package com.project.kanbanbackend.mappers;

import com.project.kanbanbackend.domains.Issue;
import com.project.kanbanbackend.domains.IssueDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueMapper {

    public Issue mapToIssue(final IssueDto issueDto){
        return new Issue(
                issueDto.getId(),
                issueDto.getTitle(),
                issueDto.getDescription(),
                issueDto.getCreateDate(),
                issueDto.getFinishDate(),
                issueDto.getType(),
                issueDto.getProject()
        );
    }

    public IssueDto mapToIssueDto(final Issue issue){
        return new IssueDto(
                issue.getId(),
                issue.getTitle(),
                issue.getDescription(),
                issue.getCreateDate(),
                issue.getFinishDate(),
                issue.getType(),
                issue.getProject()
        );
    }

    public List<IssueDto> mapToIssueDtoList(final List<Issue> issues){
        return issues.stream()
                .map(issue -> new IssueDto(issue.getId(),issue.getTitle(),issue.getDescription(),issue.getCreateDate(),
                        issue.getFinishDate(),issue.getType(),issue.getProject()))
                .collect(Collectors.toList());
    }
}
