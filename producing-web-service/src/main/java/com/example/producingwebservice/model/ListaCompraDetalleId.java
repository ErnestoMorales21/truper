package com.example.producingwebservice.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
public class ListaCompraDetalleId implements Serializable{
	

	
	@ManyToOne
    @JoinColumn(name = "id_lista")
    private ListaCompras listaCompra;
	
	@ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos producto;
	
	

    public ListaCompras getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ListaCompras listaCompra) {
		this.listaCompra = listaCompra;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

//	 @Column(name = "lista_compra_id")
//	    private Long listaCompraId;
//
//	    @Column(name = "producto_codigo")
//	    private Long productoCodigo;
	

}
