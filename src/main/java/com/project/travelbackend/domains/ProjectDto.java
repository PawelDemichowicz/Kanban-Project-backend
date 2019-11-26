package com.project.travelbackend.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate createDate;
    private LocalDate finishDate;
    private List<Issue> issues;
    private List<Note> notes;
}

