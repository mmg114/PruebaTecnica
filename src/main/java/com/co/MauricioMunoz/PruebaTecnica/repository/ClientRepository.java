package com.co.MauricioMunoz.PruebaTecnica.repository;

import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {


    Client findByIdAndActive( UUID cliendId ,Boolean active);

    Client findByEmail(String email);

}
