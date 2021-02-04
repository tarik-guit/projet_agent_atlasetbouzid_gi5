package com.agent.ag;

import com.agent.ag.Entities.Compte;
import com.agent.ag.requestresponse.SignupRequest;
import com.agent.ag.securitycontroller.AuthController;
import com.agent.ag.securitymodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
@EnableScheduling
@SpringBootApplication
public class AgApplication implements CommandLineRunner {
  @Autowired
  private AuthController u;
  @Autowired
  private Rolerepo repr;
    public static void main(String[] args) {
        SpringApplication.run(AgApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        Role r1=new Role(1,ERole.ROLE_USER);
        Role r2=new Role(2,ERole.ROLE_ADMIN);
        repr.save(r1);
        repr.save(r2);
        u.ajouteradmin();

    }
}
