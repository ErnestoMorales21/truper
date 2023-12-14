package com.example.producingwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.ListaCompraDetalleId;

import com.example.producingwebservice.model.ListaCompraDetalle;

@Repository
public interface ListaComprasDetallesRepository extends JpaRepository<ListaCompraDetalle,ListaCompraDetalleId> {
	
	

}
