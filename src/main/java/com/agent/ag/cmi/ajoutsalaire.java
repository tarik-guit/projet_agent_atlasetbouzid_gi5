package com.agent.ag.cmi;

import com.agent.ag.Entities.Compte;
import com.agent.ag.Repositories.Repocompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ajoutsalaire {
    @Autowired
    private Repocompte repc;

    @Scheduled(cron="0 0 0 1 * ?")
    public void  ajoutersoldemensuelle(){
        List<Compte> comptes=repc.findAll();
        for(Compte c:comptes){
            c.setSolde(c.getSolde()+c.getSalaire());
            repc.save(c);

        }

    }



}
