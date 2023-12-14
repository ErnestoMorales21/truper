package com.example.producingwebservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.Clientes;
import com.example.producingwebservice.model.ListaCompras;
import com.example.producingwebservice.model.Productos;
import com.example.producingwebservice.model.ListaCompraDetalle;
import com.example.producingwebservice.model.ListaCompraDetalleId;
import com.example.producingwebservice.repository.ClienteRepository;
import com.example.producingwebservice.repository.ListaComprasDetallesRepository;
import com.example.producingwebservice.repository.ListaRepository;
import com.example.producingwebservice.repository.ProductosRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

    @Autowired
    private ProductosRepository productoRepository;

    @Autowired
    private ListaRepository listaCompraRepository;

    @Autowired
    private ListaComprasDetallesRepository listaCompraDetalleRepository;
	
	@Transactional
	public Clientes crearCliente(Clientes cliente) {
		// Parsear el JSON y crear instancias de Cliente, Producto, ListaCompra, y ListaCompraDetalle
		Clientes cliente_json = cliente;
		Productos producto = new Productos();
		ListaCompras listaCompra = new ListaCompras();
		ListaCompraDetalle listaCompraDetalle = new ListaCompraDetalle();

        // Asignar instancias a la clave primaria compuesta
//		ListaCompraDetalleId id = new ListaCompraDetalleId();
//        id.setListaCompra(listaCompra);
//        id.setProducto(producto);

        // Asignar clave primaria compuesta a listaCompraDetalle
//        listaCompraDetalle.setId(id);

        // Guardar en los repositorios
        clienteRepository.save(cliente);
        productoRepository.save(producto);
        listaCompraRepository.save(listaCompra);
        listaCompraDetalleRepository.save(listaCompraDetalle);
    
		
		
		return clienteRepository.save(cliente);
		
	}
	
	public List<Clientes> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Clientes buscarId(Long id) {
		Optional<Clientes> optionalClientes = clienteRepository.findById(id);
		return optionalClientes.get();
	}

}
