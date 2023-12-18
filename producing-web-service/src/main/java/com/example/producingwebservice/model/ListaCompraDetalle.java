package com.example.producingwebservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="listaCompraDetalle")
public class ListaCompraDetalle {
	
	@EmbeddedId
    private ListaCompraDetalleId id;
	@ManyToOne
    @MapsId("idListaCompra")
    @JoinColumn(name = "idListaCompra")
    private ListaCompras listaCompras;

    @ManyToOne
    @MapsId("codigoProducto")
    @JoinColumn(name = "codigoProducto")
    private Productos productos;
	
	private int cantidad;
	

	
	
	
		

}
