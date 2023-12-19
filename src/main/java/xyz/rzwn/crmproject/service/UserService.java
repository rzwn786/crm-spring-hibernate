package xyz.rzwn.crmproject.service;

import xyz.rzwn.crmproject.dto.UserDto;
import xyz.rzwn.crmproject.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUser();
    User saveUser(UserDto userDto);

    UserDto findUserByID(long userID);

    void updateUser(UserDto user);

    void delete(Long userID);
}

