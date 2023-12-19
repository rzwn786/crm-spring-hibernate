package xyz.rzwn.crmproject.service.impl;

import org.springframework.stereotype.Service;
import xyz.rzwn.crmproject.dto.UserDto;
import xyz.rzwn.crmproject.model.User;
import xyz.rzwn.crmproject.repository.UserRepository;
import xyz.rzwn.crmproject.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = mapToUser(userDto);
        return userRepository.save(user);
    }

    @Override
    public UserDto findUserByID(long userID) {
        User user = userRepository.findById(userID).get();
        return mapToUserDto(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = mapToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void delete(Long userID) {
        userRepository.deleteById(userID);
    }

    private User mapToUser(UserDto user) {
        User userDto = User.builder()
                .userID(user.getUserID())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .userEmail(user.getUserEmail())
                .userPhone(user.getUserPhone())
                .password(user.getPassword())
                .roleID(user.getRoleID())
                .build();
        return userDto;
    }

    private UserDto mapToUserDto (User user){
        UserDto userDto = UserDto.builder()
                .userID(user.getUserID())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userEmail(user.getUserEmail())
                .userPhone(user.getUserPhone())
                .password(user.getPassword())
                .roleID(user.getRoleID())
                .build();
        return userDto;
    }
}
