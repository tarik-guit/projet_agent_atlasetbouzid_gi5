package com.agent.ag.Controllers;

import com.agent.ag.Entities.Form_enr_ag;
import com.agent.ag.Repositories.RepoForm_enr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class Controform_enr {


    @Autowired
    private RepoForm_enr rep;

    @GetMapping("/form_enrs")
    public List<Form_enr_ag> getallformsnontraite() {
        return rep.getallnontraite(0);
    }

    @DeleteMapping("/form_enrs")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/form_enr/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/form_enr")
    public Form_enr_ag creerformenr(@RequestBody Form_enr_ag form) {

        return  rep.save(form);
    }

    @PutMapping("/trait_form_enr/{id}")
    public Form_enr_ag traite(@PathVariable Long id) {
        Form_enr_ag form= rep.findById(id).get();

            form.setProcessed(1);

        return rep.save(form);
    }

    @GetMapping("/form_enrs_tr")
    public List<Form_enr_ag> getallformstraite() {
        return rep.getallnontraite(1);
    }


}
