package com.antonypalomino.service;

import java.util.List;

import com.antonypalomino.dto.ProductoDTORequest;
import com.antonypalomino.dto.ProductoDTOresponse;
import com.antonypalomino.model.Productos;

public interface ProductosService {

	void guardarProducto(ProductoDTORequest producto);
	void actualizarProducto(ProductoDTORequest producto);
	void eliminarProducto(Integer id);
	List<ProductoDTOresponse> listarProductos();
	ProductoDTOresponse obtenerProductoId(Integer id);
}
