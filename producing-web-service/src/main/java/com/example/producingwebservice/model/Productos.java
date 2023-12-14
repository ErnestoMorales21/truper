package com.example.producingwebservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="productos")
public class Productos {
	
	@Id
	private Long idProducto;
	@Column(name="clave", columnDefinition="varchar(15)") 
	private String clave;
	@Column(name="descripcion", columnDefinition="char(50)") 
	private String descripcion;
	private Boolean activoBit;
	
	 @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ListaCompraDetalle> listaComprasDetalle = new ArrayList<ListaCompraDetalle>();
	
	
	
	

}
