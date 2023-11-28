package com.co.MauricioMunoz.PruebaTecnica.repository;

import com.co.MauricioMunoz.PruebaTecnica.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
