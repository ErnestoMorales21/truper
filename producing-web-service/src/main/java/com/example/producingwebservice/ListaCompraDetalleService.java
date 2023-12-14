package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.ListaCompras;
import com.example.producingwebservice.model.Productos;
import com.example.producingwebservice.model.ListaCompraDetalleId;
import com.example.producingwebservice.model.Clientes;
import com.example.producingwebservice.model.ListaCompraDetalle;

import com.example.producingwebservice.repository.ClienteRepository;
import com.example.producingwebservice.repository.ListaComprasDetallesRepository;

import jakarta.transaction.Transactional;

@Service
public class ListaCompraDetalleService {
	
	@Autowired
	private ListaComprasDetallesRepository listaComprasDetallesRepository;
	
	
	
	@Transactional
	public ListaCompraDetalle crearlistaCompraDetalle(ListaCompraDetalle listaCompraDetalle) {
		
		ListaCompras listaCompra = new ListaCompras();
		Productos producto = new Productos();

		ListaCompraDetalleId id = new ListaCompraDetalleId();
//		id.setListaCompra(listaCompra);
//		id.setProducto(producto);


		ListaCompraDetalle listaCompraDetalle_id = new ListaCompraDetalle();
		listaCompraDetalle_id.setId(id);


		return listaComprasDetallesRepository.save(listaCompraDetalle);
		
	}
	


}
