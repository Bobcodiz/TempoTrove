package com.codiz.TempoTrove.controller;

import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    private final UserService userService;

    @RequestMapping(value = "/api/v1/create",method = RequestMethod.POST)
    private ResponseEntity<String> createUser( @RequestBody UserDto userDto)
    {
        log.info("creating new user");
        return ResponseEntity.ok(userService.createUser(userDto));
    }

}
