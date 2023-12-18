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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    
    @PersistenceContext
    private EntityManager entityManager;
    
	
	
	
	public List<Clientes> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public ListaCompras buscarId(Long id) {
		Optional<ListaCompras> optionalClientes = listaCompraRepository.findById(id);
		return optionalClientes.get();
	}
	
	public Clientes actualizarListaCompras(Long idCliente, List<ListaCompras> nuevaLista) {
		Clientes cliente = clienteRepository.findById(idCliente).orElseThrow();

	        cliente.setListaCompras(nuevaLista);

	        return clienteRepository.save(cliente);
	    
	}
	
	public void deleteLista(Long id) {
		listaCompraRepository.deleteById(id);
	}
	
	 	
		@Transactional
	    public Clientes crearCliente(Clientes cliente) {
			
			
			
	    	Clientes cliente_obj = new Clientes();
	    	cliente_obj.setIdCliente(cliente.getIdCliente());
	    	cliente_obj.setNombre(cliente.getNombre());
	    	cliente_obj.setActivoBit(cliente.getActivoBit());

	        for (int i = 0; i < cliente.getListaCompras().size(); i++) {
	        	ListaCompras listaCompra = new ListaCompras();
	            listaCompra.setNombre(cliente.getListaCompras().get(i).getNombre());
	            listaCompra.setActivoBit(cliente.getListaCompras().get(i).getActivoBit());

	            listaCompra.setClientes(cliente);

//	            JSONArray listaComprasDetalleJson = listaCompraJson.getJSONArray("listaComprasDetalle");
	            for (int j = 0; j < cliente.getListaCompras().get(i).getListaComprasDetalle().size(); j++) {
//	                JSONObject listaCompraDetalleJson = listaComprasDetalleJson.getJSONObject(j);
	                int cantidadDetalle = cliente.getListaCompras().get(i).getListaComprasDetalle().get(j).getCantidad();
//	                int cantidad = listaCompraDetalleJson.getInt("cantidad");

	                ListaCompraDetalle listaCompraDetalle = new ListaCompraDetalle();
	                listaCompraDetalle.setCantidad(cantidadDetalle);

	                // Obtener o crear el Producto
//	                Long codigoProducto = listaCompraJson.getLong("codigoProducto");
	                Long codigoProd = cliente.getListaCompras().get(i).getListaComprasDetalle().get(j).getProductos().getIdProducto();
	                Productos producto = productoRepository.findById(codigoProd).orElseGet(() -> {
	                	Productos nuevoProducto = new Productos();
	                    nuevoProducto.setIdProducto(codigoProd);
	                    nuevoProducto.setDescripcion("producto"); // Puedes establecer otros valores
	                    return productoRepository.save(nuevoProducto);
	                });

	                // Asignar Producto y ListaCompraDetalle a la relación
	                
	                entityManager.persist(listaCompra);
	                Long idListaCompraGenerado = listaCompra.getIdLista();
	                listaCompraDetalle.setProductos(producto);
	                listaCompraDetalle.setListaCompras(listaCompra);
	                ListaCompraDetalleId id = new ListaCompraDetalleId();
	                id.setCodigoProducto(producto.getIdProducto());
	                id.setIdListaCompra(idListaCompraGenerado);
	                listaCompraDetalle.setId(id);
	                entityManager.persist(listaCompraDetalle);

	                listaCompra.getListaComprasDetalle().add(listaCompraDetalle);
	                
	            }

	            // Guardar ListaCompra y sus detalles
//	            entityManager.persist(clientes);
	            cliente.getListaCompras().set(i, listaCompra);
	            listaCompraRepository.save(listaCompra);
	            
	        }

	        // Guardar Cliente y sus ListaCompras
	        return clienteRepository.save(cliente);
	    }
	    

}
