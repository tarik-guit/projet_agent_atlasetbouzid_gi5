package com.agent.ag.requestresponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequest {

    private String username;


    private String password;



    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }
}
