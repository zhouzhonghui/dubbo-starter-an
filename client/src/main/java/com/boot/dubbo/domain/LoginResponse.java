package com.boot.dubbo.domain;

public class LoginResponse extends BaseResponse{
    private static final long serialVersionUID = 4948173449648182350L;
    private String name;

    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
