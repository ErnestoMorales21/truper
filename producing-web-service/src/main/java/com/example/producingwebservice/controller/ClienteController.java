package com.example.producingwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producingwebservice.ClienteService;
import com.example.producingwebservice.model.Clientes;
import com.example.producingwebservice.model.ListaCompras;
import com.example.producingwebservice.model.Productos;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Clientes crearLista (@RequestBody Clientes clientes) {
		return clienteService.crearCliente(clientes);
	}
	
	@GetMapping
	public ListaCompras buscarLista (@PathVariable Long id) {
		return  clienteService.buscarId(id);
	}
	
	@PutMapping("/{clienteId}/listaProductos")
    public ResponseEntity<Clientes> actualizarListaPrecios(
            @PathVariable Long clienteId,
            @RequestBody List<ListaCompras> nuevaLista) {
		Clientes clienteActualizado = clienteService.actualizarListaCompras(clienteId, nuevaLista);
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }
	
	@DeleteMapping("{id")
	public void eliminarLista(@PathVariable Long id) {
		clienteService.deleteLista(id);
		
	}
	
	
	

	
	
}
