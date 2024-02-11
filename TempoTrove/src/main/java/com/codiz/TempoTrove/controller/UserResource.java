package com.codiz.TempoTrove.controller;

import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.model.UserModel;
import com.codiz.TempoTrove.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    private final UserService userService;

    @RequestMapping(value = "/api/v1/create",method = RequestMethod.POST)
    private ResponseEntity<String> createUser( @RequestBody UserDto userDto)
    {
        log.info("creating new user");
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/v1/delete",method = RequestMethod.DELETE)
    private ResponseEntity<String> deleteUser(@RequestParam String username)
    {
        log.info("request to delete user");
        return new ResponseEntity<>(userService.deleteUser(username));
    }

    @RequestMapping(value = "/api/v1/findUser",method = RequestMethod.GET)
    private UserModel findUser(@RequestParam String username){
        log.info("finding one user");
        userService.findUser(username);
        return new UserModel();
    }

}
