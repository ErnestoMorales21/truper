package com.example.producingwebservice.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class ListaCompraDetalleId implements Serializable{
	

	
	private Long idListaCompra;
    private Long codigoProducto;
	
	

    
	

}
