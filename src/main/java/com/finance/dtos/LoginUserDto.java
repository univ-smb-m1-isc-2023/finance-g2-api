package com.finance.dtos;

public class LoginUserDto {
    private String email;
    
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }
    
    
    // getters and setters here...
}
