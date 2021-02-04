package com.agent.ag.Repositories;

import com.agent.ag.Entities.Client;
import com.agent.ag.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repocompte extends JpaRepository<Compte,Long> {

    @Query("SELECT n FROM Compte n WHERE n.client.id=:ide")
    List<Compte> getallforaclient(@Param("ide") Long ide );

    @Query("SELECT n FROM Compte n WHERE n.client.tel=:tel")
    List<Compte> getallcompteforuser(@Param("tel") String tel );
}
