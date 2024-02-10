package com.codiz.TempoTrove.service;

import com.codiz.TempoTrove.custom.EntityAlreadyExistException;
import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.repository.UserResourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserResourceRepository userResourceRepository;
    @Override
    public String createUser(UserDto userDto)
    {

        log.info("service to create a new user");

        //check if the user exists
        if (userResourceRepository.existsByUsername(userDto.getUsername()))
        {
            log.info("checking if user with the same username exists");
            throw new EntityAlreadyExistException
                    ("user with that username already exists");
        }



        return null;
    }
}
