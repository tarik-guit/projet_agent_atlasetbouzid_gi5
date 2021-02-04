package com.agent.ag.services;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Supprimerclient {
    @Autowired
    private catchjwt jwtc;
    @Autowired
    private RestTemplate restTemplate;

    public JSONObject supprimeraclientcompte(String username) {
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        this.jwtc.avoirjwt();
        headers.add("Authorization", this.jwtc.getJwt_ml_f());
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8003/deleteuser/"+username, HttpMethod.DELETE,entity, JSONObject.class).getBody();


    }
}
