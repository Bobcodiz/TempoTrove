package com.codiz.TempoTrove.controller;

import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    private ResponseEntity<String> createUser(UserDto userDto)
    {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

}
