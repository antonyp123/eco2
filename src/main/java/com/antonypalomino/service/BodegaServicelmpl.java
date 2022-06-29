package com.antonypalomino.service;

import java.util.ArrayList;
import java.util.List;

import com.antonypalomino.dto.BodegasDTOrequest;
import com.antonypalomino.dto.BodegasDTOresponse;
import com.antonypalomino.model.Bodega;
import com.antonypalomino.repository.BodegaRepository;



public class BodegaServicelmpl implements BodegasService {
	
	
	private BodegaRepository repobodega;

	@Override
	public void guardarBodegas(BodegasDTOrequest Bodegas) {
		Bodega p = new Bodega(null, null, null, null);
		p.setNombre(p.getNombre());
		p.setDireccion(p.getDireccion());
		p.setIdProductos(p.getIdProductos());
		
		repobodega.save(p);
		
	}

	@Override
	public void actualizarbodegas(BodegasDTOrequest Bodegas) {	
		Bodega p = new Bodega(null, null, null, null);
		p.setNombre(p.getNombre());
		p.setDireccion(p.getDireccion());
		p.setIdProductos(p.getIdProductos());
		repobodega.saveAndFlush(p);
		
	}

	@Override
	public void eliminarbodegas(Integer id) {
		repobodega.deleteById(id);
	}

	@Override
	public List<BodegasDTOresponse> listarProductos() {

		List<BodegasDTOresponse> listar = new ArrayList<>();
		
		BodegasDTOresponse dto = null;
		
		List<Bodega> p = repobodega.findAll();
		
		for (Bodega bodega : p) {
			
			dto = new BodegasDTOresponse();
			
			dto.setNombre(bodega.getNombre());
			dto.setDireccion(bodega.getDireccion());
			
		

			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public BodegasDTOresponse obtenerBodegasId(Integer id) {
		Bodega bodega = repobodega.findById(id).orElse(null);
		BodegasDTOresponse  dto = new BodegasDTOresponse();
		
		dto.setNombre(bodega.getNombre());
		dto.setDireccion(bodega.getDireccion());		
		return dto;
	}





}
