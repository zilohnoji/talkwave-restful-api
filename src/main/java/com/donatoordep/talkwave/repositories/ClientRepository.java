package com.donatoordep.talkwave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donatoordep.talkwave.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
