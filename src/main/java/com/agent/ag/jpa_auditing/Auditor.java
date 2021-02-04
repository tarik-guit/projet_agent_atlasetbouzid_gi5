package com.agent.ag.jpa_auditing;

import com.agent.ag.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class Auditor implements AuditorAware<String> {
  @Autowired
 public AuthController u;

    @Override
    public Optional<String> getCurrentAuditor(){
        String username;
        if(u.getUsername()==null){username="client";}else{username=u.getUsername();}
        return Optional.of(username);
    }
}