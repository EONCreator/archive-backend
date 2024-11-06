package com.archiveapp.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto
{
    private Long id;
    @NotEmpty
    private String userName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public CharSequence getPassword() {
        return password;
    }
}