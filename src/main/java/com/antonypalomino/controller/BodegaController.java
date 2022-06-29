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

import com.antonypalomino.dto.BodegasDTOrequest;
import com.antonypalomino.dto.BodegasDTOresponse;

import com.antonypalomino.service.BodegasService;




@Controller
@RequestMapping("/bodega/v1")
public class BodegaController {
	
	@Autowired
	private BodegasService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<BodegasDTOresponse>>  listar() {
		
		return new ResponseEntity<List<BodegasDTOresponse>>(service.listarProductos(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody BodegasDTOrequest Bodegas) {
		service.guardarBodegas(Bodegas);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		BodegasDTOresponse p =service.obtenerBodegasId(id);
		if(p != null) {
			service.eliminarbodegas(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody BodegasDTOrequest Bodega) {
		BodegasDTOresponse p =service.obtenerBodegasId(Bodega.getIdBodega());
		if(p != null) {
			service.actualizarbodegas(Bodega);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<BodegasDTOresponse> obtenerId(@PathVariable Integer id) {
		BodegasDTOresponse p =service.obtenerBodegasId(id);
		if(p != null) {
			return  new ResponseEntity<BodegasDTOresponse>(service.obtenerBodegasId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<BodegasDTOresponse>(HttpStatus.NOT_FOUND);
	}


}
