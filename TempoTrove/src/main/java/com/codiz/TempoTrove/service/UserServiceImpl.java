package com.codiz.TempoTrove.service;

import com.codiz.TempoTrove.custom.EntityAlreadyExistException;
import com.codiz.TempoTrove.custom.IncorrectFormatExceptions;
import com.codiz.TempoTrove.dto.UserDto;
import com.codiz.TempoTrove.model.UserModel;
import com.codiz.TempoTrove.repository.UserResourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            log.error("checking if user with the same username exists");
            throw new EntityAlreadyExistException
                    ("user with that username already exists");
        }

        // inserting the details from dto to the db
        try {
            log.info("inserting details to the db");
            UserModel user = new UserModel();
            user.setUsername(userDto.getUsername());
            if (!EmailValidator.getInstance().isValid(userDto.getEmail()))
            {
                log.error("incorrect email format");
                throw new IncorrectFormatExceptions("incorrect format");
            }else {
                user.setEmail(userDto.getEmail());
            }
            boolean isValid = PhoneNumberValidator(userDto.getPhone());
            if(!isValid)
            {
                log.error("incorrect phone number format");
                throw new IncorrectFormatExceptions("incorrect format");
            }else {
                user.setPhone(userDto.getPhone());
            }
            if (Objects.equals(userDto.getPassword(), userDto.getConfirmPassword())){
                user.setPassword(userDto.getPassword());
            }else {
                log.error("password do not match");
                throw new IncorrectFormatExceptions("credentials do not match");
            }


            userResourceRepository.save(user);

        }
        catch (Exception e){
            log.error("an error occurred");
        }

        return null;
    }
    private boolean PhoneNumberValidator(String phone){
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

}
