package com.antonypalomino.service;

import java.util.List;

import com.antonypalomino.dto.BodegasDTOrequest;
import com.antonypalomino.dto.BodegasDTOresponse;




public interface BodegasService {

	void guardarBodegas(BodegasDTOrequest Bodegas);
	void actualizarbodegas(BodegasDTOrequest Bodegas);
	void eliminarbodegas(Integer id);
	List<BodegasDTOresponse> listarProductos();
	BodegasDTOresponse obtenerBodegasId(Integer id);
}
