package com.antonypalomino.service;

import java.util.ArrayList;
import java.util.List;

import com.antonypalomino.dto.ProductoDTORequest;
import com.antonypalomino.dto.ProductoDTOresponse;
import com.antonypalomino.model.Productos;
import com.antonypalomino.repository.ProductoRepository;

public class ProductoServicelmpl implements ProductosService {
	
	private ProductoRepository repoProduc;

	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		Productos p = new Productos();
		p.setProducto(producto.getProducto());
		p.setDescripcion(p.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(p.getStock());
		repoProduc.save(p);
		
	}

	@Override
	public void actualizarProducto(ProductoDTORequest producto) {
		// TODO Auto-generated method stub
		Productos p = new Productos();
		p.setProducto(producto.getProducto());
		p.setDescripcion(p.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(p.getStock());
		repoProduc.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repoProduc.deleteById(id);
	}

	@Override
	public List<ProductoDTOresponse> listarProductos() {
		List<ProductoDTOresponse> listar = new ArrayList<>();
		
		ProductoDTOresponse dto = null;
		
		List<Productos> p = repoProduc.findAll();
		
		for (Productos productos : p) {
			
			dto = new ProductoDTOresponse();
			
			dto.setProducto(productos.getProducto());
			dto.setDescripcion(productos.getDescripcion());
			dto.setPrecio(productos.getPrecio());
			dto.setStock(productos.getStock());

			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ProductoDTOresponse obtenerProductoId(Integer id) {
		Productos productos = repoProduc.findById(id).orElse(null);
		ProductoDTOresponse dto = new ProductoDTOresponse();
		
		dto.setProducto(productos.getProducto());
		dto.setDescripcion(productos.getDescripcion());
		dto.setPrecio(productos.getPrecio());
		dto.setStock(productos.getStock());		
		return dto;
	}



}
