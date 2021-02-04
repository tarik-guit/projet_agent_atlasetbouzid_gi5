package com.agent.ag.Repositories;

import com.agent.ag.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repoclient extends JpaRepository<Client,Long> {

    @Query("SELECT n FROM Client n WHERE n.createdby=:username")
    List<Client> getall(@Param("username") String username );


    @Query("SELECT n FROM Client  n WHERE n.tel=:username")
    Client getclientbytel(@Param("username") String username );
}
