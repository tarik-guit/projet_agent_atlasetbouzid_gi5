package com.agent.ag.cmi;


import com.agent.ag.Entities.Compte;
import com.agent.ag.Repositories.Repocompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class retrancher {

    @Autowired
    private Repocompte repc;

    @Secured("ROLE_ADMIN")
    @GetMapping("/retranchersomme/{tel}/{prix}")
    public String retrancher(@PathVariable String tel, @PathVariable int prix) {

        List<Compte> comptes = repc.getallcompteforuser(tel);
        int somme = prix;

        for (Compte c : comptes) {
            if (somme == 0) {
                break;
            }
            if (somme < c.getSolde()) {
                c.setSolde(c.getSolde() - somme);
                break;
            } else {
                somme = somme - c.getSolde();
                c.setSolde(0);
            }
            repc.save(c);
        }
        return "facture payée";
    }
}
