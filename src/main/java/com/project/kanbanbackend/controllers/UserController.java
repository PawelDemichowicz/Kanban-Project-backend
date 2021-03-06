package com.project.kanbanbackend.controllers;

import com.project.kanbanbackend.domains.UserDto;
import com.project.kanbanbackend.mappers.UserMapper;
import com.project.kanbanbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper mapper;

    @PostMapping(value = "user", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto){
        service.createUser(mapper.mapToUser(userDto));
    }

    @PutMapping(value = "user")
    public void remindPassword(@RequestBody UserDto userDto){
        service.updateUser(mapper.mapToUser(userDto));
    }
}
