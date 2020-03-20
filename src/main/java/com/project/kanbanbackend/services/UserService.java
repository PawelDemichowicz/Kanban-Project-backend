package com.project.kanbanbackend.services;

import com.project.kanbanbackend.domains.User;
import com.project.kanbanbackend.exceptions.UserNotFoundExceptions;
import com.project.kanbanbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void createUser(final User user){
        repository.save(user);
    }

    public void updateUser(final User newUser){
        User user = repository.findById(newUser.getId()).orElseThrow(UserNotFoundExceptions::new);
        user.setPassword(newUser.getPassword());
        repository.save(user);
    }
}
