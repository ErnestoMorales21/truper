package com.example.producingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producingwebservice.ClienteService;
import com.example.producingwebservice.model.Clientes;
import com.example.producingwebservice.model.ListaCompras;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Clientes crearLista (@RequestBody Clientes clientes) {
		return clienteService.crearCliente(clientes);
	}

	
	
}
