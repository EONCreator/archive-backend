package com.archiveapp.demo.controllers;

import com.archiveapp.demo.entity.User;
import com.archiveapp.demo.models.UserDto;
import com.archiveapp.demo.service.security.user.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/signup")
    public String registration(@RequestBody UserDto userDto,
                               BindingResult result){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", "401",
                    "Аккаунт с таким email уже существует");
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
}