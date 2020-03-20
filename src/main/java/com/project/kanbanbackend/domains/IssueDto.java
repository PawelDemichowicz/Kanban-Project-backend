package com.project.kanbanbackend.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate createDate;
    private LocalDate finishDate;
    private IssueType type;
    private Project project;
}
