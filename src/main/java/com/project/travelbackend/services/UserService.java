package com.project.travelbackend.services;

import com.project.travelbackend.domains.User;
import com.project.travelbackend.exceptions.UserNotFoundExceptions;
import com.project.travelbackend.repositories.UserRepository;
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
