package com.codiz.TempoTrove.service;

import com.codiz.TempoTrove.dto.UserDto;
import org.springframework.http.HttpStatusCode;

public interface UserService {
    String createUser(UserDto userDto);

    HttpStatusCode deleteUser(String username);

    String findUser(String username);
}
