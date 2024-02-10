package com.codiz.TempoTrove.controller;

import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    private final UserService userService;

    private ResponseEntity<String> createUser(UserDto userDto)
    {
        log.info("creating new user");
        return ResponseEntity.ok(userService.createUser(userDto));
    }

}
