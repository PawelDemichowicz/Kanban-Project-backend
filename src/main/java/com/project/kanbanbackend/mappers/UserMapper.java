package com.project.kanbanbackend.mappers;

import com.project.kanbanbackend.domains.User;
import com.project.kanbanbackend.domains.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.isAuthorized(),
                userDto.getTypeAccount(),
                userDto.getEmailAddress(),
                userDto.getName(),
                userDto.getSurname()

        );
    }

    public UserDto mapToUserDto(final User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.isAuthorized(),
                user.getTypeAccount(),
                user.getEmailAddress(),
                user.getName(),
                user.getSurname()
        );
    }
}
