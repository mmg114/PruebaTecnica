package com.co.MauricioMunoz.PruebaTecnica.repository;

import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client,Long> {


    Client findById(@Param("userId") UUID cliendId);

    Client findByEmail(String email);
}
