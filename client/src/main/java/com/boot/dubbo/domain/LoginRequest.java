package com.boot.dubbo.domain;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class LoginRequest extends BaseRequest{
    private static final long serialVersionUID = 5366557840304411218L;
    @NotEmpty(message = "isv.LoginRequest.name.is.null")
    private String name;
    @NotEmpty(message = "isv.LoginRequest.passwd.is.null")
    private String passwd;
    @Email(message = "isv.LoginRequest.email.is.null")
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
