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

import com.antonypalomino.dto.ProductoDTORequest;
import com.antonypalomino.dto.ProductoDTOresponse;

import com.antonypalomino.service.ProductosService;


@Controller
@RequestMapping("/producto/v1")
public class ProductoController {
	

	@Autowired
	private ProductosService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ProductoDTOresponse>>  listar() {
		
		return new ResponseEntity<List<ProductoDTOresponse>>(service.listarProductos(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest productos) {
		service.guardarProducto(productos);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ProductoDTOresponse p =service.obtenerProductoId(id);
		if(p != null) {
			service.eliminarProducto(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ProductoDTORequest productos) {
		ProductoDTOresponse p =service.obtenerProductoId(productos.getIdProducto());
		if(p != null) {
			service.actualizarProducto(productos);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductoDTOresponse> obtenerId(@PathVariable Integer id) {
		ProductoDTOresponse p =service.obtenerProductoId(id);
		if(p != null) {
			return  new ResponseEntity<ProductoDTOresponse>(service.obtenerProductoId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ProductoDTOresponse>(HttpStatus.NOT_FOUND);
	}

}
