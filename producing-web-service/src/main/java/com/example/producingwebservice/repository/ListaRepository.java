package com.example.producingwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.ListaCompras;

@Repository
public interface ListaRepository extends JpaRepository<ListaCompras,Long>{

}
