package com.agent.ag.Entities;

import com.agent.ag.jpa_auditing.auditingclasse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Client extends auditingclasse<String> implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private  String tel;
    @Column
    private  String email;
    @Column
    private  String numcin;
    @Column
    private  String remarque;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Compte> comptes=new HashSet<Compte>(0);


}
