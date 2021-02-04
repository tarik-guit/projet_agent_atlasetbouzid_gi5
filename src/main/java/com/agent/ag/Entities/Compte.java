package com.agent.ag.Entities;

import com.agent.ag.jpa_auditing.auditingclasse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Compte extends auditingclasse<String> implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int  solde;
    @Column
    private int  salaire;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Client client;

}
