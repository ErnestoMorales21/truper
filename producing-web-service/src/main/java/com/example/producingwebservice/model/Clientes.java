package com.example.producingwebservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Clientes")
public class Clientes {
	
	@Id 
	@Column(name = "idCliente", nullable = false)
	private Integer idCliente;
	@Column(name="nombre", columnDefinition="char(50)",nullable = false) 
	private String nombre;
	private Boolean activoBit;
	@OneToMany( mappedBy = "clientes", cascade=CascadeType.ALL, orphanRemoval = true) 
    private List<ListaCompras> listaCompras = new ArrayList<ListaCompras>();
	
	

	
}
