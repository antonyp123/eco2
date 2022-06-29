package com.antonypalomino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antonypalomino.dto.ClienteDTORequest;
import com.antonypalomino.dto.ClienteDTOresponse;
import com.antonypalomino.service.ClienteService;




@Controller
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ClienteDTOresponse>>  listar() {
		
		return new ResponseEntity<List<ClienteDTOresponse>>(service.listarCLiente(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cliente) {
		service.guardarCliente(cliente);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ClienteDTOresponse p =service.obtenercliente(id);
		if(p != null) {
			service.eliminarCliente(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ClienteDTORequest cliente) {
		ClienteDTOresponse p =service.obtenercliente(cliente.getIdCliente());
		if(p != null) {
			service.actualizarCliente(cliente);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOresponse> obtenerId(@PathVariable Integer id) {
		ClienteDTOresponse p =service.obtenercliente(id);
		if(p != null) {
			return  new ResponseEntity<ClienteDTOresponse>(service.obtenercliente(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ClienteDTOresponse>(HttpStatus.NOT_FOUND);
	}

}
