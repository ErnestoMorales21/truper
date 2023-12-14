package com.example.producingwebservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name="listacompras")
public class ListaCompras {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLista;
	private Integer costumer_int;
	@Column(name="nombre", columnDefinition="char(50)") 
	private String nombre;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimaActualizacion;
	private Boolean activoBit;
	
	@ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes clientes;
	
	 @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ListaCompraDetalle> listaComprasDetalle = new ArrayList<ListaCompraDetalle>();
	

	
	
}
