package com.agent.ag.securitymodels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Useraide {
    private String username;
    private String previouspassword;
    private String password;
    private String passwordconfirm;

}
