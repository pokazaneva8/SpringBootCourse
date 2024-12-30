package com.example.test_security2db_themeleaf.service;



import com.example.test_security2db_themeleaf.dto.UserDto;
import com.example.test_security2db_themeleaf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
