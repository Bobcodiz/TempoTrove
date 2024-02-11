package com.codiz.TempoTrove.service;

import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public interface UserService {
    String createUser(UserDto userDto);

    HttpStatusCode deleteUser(String username);

    UserModel findUser(String username);
}
