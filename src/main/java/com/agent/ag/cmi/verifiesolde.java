package com.agent.ag.cmi;

import com.agent.ag.Entities.Compte;
import com.agent.ag.Repositories.Repocompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin()
public class verifiesolde {

    @Autowired
    private Repocompte repc;

    @GetMapping("/soldesuffisant/{tel}/{prix}")
    public aide soldesuffisant(@PathVariable String tel, @PathVariable int prix) {

        List<Compte> comptes = repc.getallcompteforuser(tel);
        int somme = 0;
        for (Compte c : comptes) {
            somme = somme + c.getSolde();

        }
        if (somme >= prix) {
            return new aide(1);
        }
        return new aide(0);
    }



}