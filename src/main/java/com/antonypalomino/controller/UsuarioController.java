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

import com.antonypalomino.dto.UsuarioDTOrequest;
import com.antonypalomino.dto.UsuarioDTOrespose;
import com.antonypalomino.service.UsuarioService;







@Controller
@RequestMapping("/Usuario/v1")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UsuarioDTOrespose>>  listar() {
		
		return new ResponseEntity<List<UsuarioDTOrespose>>(service.listarUsuario(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioDTOrequest usuario) {
		service.guardarUusario(usuario);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		UsuarioDTOrespose p =service.obtenerUsuariosId(id);
		if(p != null) {
			service.eliminarUsuairo(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody UsuarioDTOrequest usuario) {
		UsuarioDTOrespose p =service.obtenerUsuariosId(usuario.getIdUsuario());
		if(p != null) {
			service.actualizarUsuario(usuario);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTOrespose> obtenerId(@PathVariable Integer id) {
		UsuarioDTOrespose p =service.obtenerUsuariosId(id);
		if(p != null) {
			return  new ResponseEntity<UsuarioDTOrespose>(service.obtenerUsuariosId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<UsuarioDTOrespose>(HttpStatus.NOT_FOUND);
	}

}
