package com.example.producingwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes,Long>{

}
