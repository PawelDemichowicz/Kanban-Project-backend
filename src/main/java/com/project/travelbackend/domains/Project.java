package com.project.travelbackend.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PROJECT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROJECT_ID", unique = true)
    private Long id;

    @Column(name = "TITLE", unique = true)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_DATE")
    private LocalDate createDate;

    @Column(name = "FINISH_DATE")
    private LocalDate finishDate;

    @OneToMany(
            targetEntity = Issue.class,
            mappedBy = "project",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Issue> issues = new ArrayList<>();

    @OneToMany(
            targetEntity = Note.class,
            mappedBy = "project",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Note> notes = new ArrayList<>();
}

