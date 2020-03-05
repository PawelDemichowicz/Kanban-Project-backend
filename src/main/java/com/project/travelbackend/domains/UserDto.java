package com.project.travelbackend.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private boolean isAuthorized;
    private String typeAccount;
    private String emailAddress;
    private String name;
    private String surname;

}
