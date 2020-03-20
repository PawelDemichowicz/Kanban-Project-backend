package com.project.kanbanbackend.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isAuthorized")
    private boolean isAuthorized;

    @Column(name = "typeAccount")
    private String typeAccount;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
