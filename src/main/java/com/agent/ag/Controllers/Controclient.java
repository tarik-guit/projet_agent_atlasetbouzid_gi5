package com.agent.ag.Controllers;


import com.agent.ag.Entities.Client;
import com.agent.ag.Repositories.Repoclient;
import com.agent.ag.envoieemail.MyConstants;
import com.agent.ag.envoieemail.Sendemail;
import com.agent.ag.requestresponse.MessageResponse;
import com.agent.ag.requestresponse.SignupRequest;
import com.agent.ag.securitycontroller.AuthController;
import com.agent.ag.services.Createclient;
import com.agent.ag.services.Supprimerclient;
import com.agent.ag.services.genererpassword;
import net.minidev.json.JSONObject;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
public class Controclient {

    @Autowired
    private Repoclient rep;
    @Autowired
    private Createclient create;
    @Autowired
    private Supprimerclient supp;
    @Autowired
    private genererpassword gen;
    @Autowired
    public AuthController u;
    @Autowired
    private Sendemail send;
    @GetMapping("/myclients")
    public List<Client> getallclientofcurrentagent() {
        return rep.getall(u.getUsername());
    }

    @GetMapping("/clients")
    public List<Client> getallclients() {
        return rep.findAll();
    }


    @DeleteMapping("/clients")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/client/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/client")
    public MessageResponse creereagent(@RequestBody Client client) {
        Set<String> role= new HashSet<String>();
        role.add("user");
        String password=gen.generateCommonLangPassword();
        JSONObject json = create.createagentcompte(new SignupRequest(client.getTel(),client.getEmail(),role,password));
        if(json.get("message").toString().equals("User registered successfully!")){rep.save(client);
            //*****envoie email
            String subject="Ensa Pay (Demande de candidature)";
            String text="Ensa Pay: Bonjour Madame/Monsieur:"+client.getNom()+" "+client.getPrenom()+" vous etes admis votre mot de passe" +
                    "  est: "+password+" et le  username: "+client.getTel()+" connectez vous et modifiez le pour plus de securité"+".Remarque: "+client.getRemarque();
            String email=client.getEmail();
            MyConstants my=new MyConstants(email,subject,text);
            send.sendSimpleEmail(my);
            // ********new MessageResponse("Error: Username is already taken!")

            return new MessageResponse("Client registered successfully!"); }
        if(json.get("message").toString().equals("Error: Username is already taken!")){return new MessageResponse("Error: Username is already taken!"); }
        if(json.get("message").toString().equals("Error: Email is already in use!")){return new MessageResponse("Error: Email is already in use!"); }

        return new MessageResponse("Agent not registred");
    }

    @GetMapping("/verifiauth")
    public void verifierauth() {

    }

    @DeleteMapping("/deleteclient/{username}")
    public MessageResponse supprimeragent(@PathVariable String username) {
        Client client =rep.getclientbytel(username);
        JSONObject json = supp.supprimeraclientcompte(username);

        if(json.get("message").toString().equals("C")){
            //*****envoie email
            String subject="Ensa Pay (Compte supprimé)";
            String text="Ensa Pay: Bonjour Madame/Monsieur:"+client.getNom()+" "+client.getPrenom()+" Votre compte a été supprimé vous pouver plus" +
                    " vous connecter a Ensa Pay ";
            String email=client.getEmail();
            MyConstants my=new MyConstants(email,subject,text);
            send.sendSimpleEmail(my);
            // ********
            rep.deleteById(client.getId());
            return new MessageResponse("Client deleted successfully!"); }
        return new MessageResponse("Client not deleted");
    }

}
