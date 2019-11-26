package com.project.travelbackend.mappers;

import com.project.travelbackend.domains.User;
import com.project.travelbackend.domains.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.isAuthorized()
        );
    }

    public UserDto mapToUserDto(final User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.isAuthorized()
        );
    }
}
