package com.antonypalomino.service;

import java.util.ArrayList;
import java.util.List;

import com.antonypalomino.dto.ClienteDTORequest;
import com.antonypalomino.dto.ClienteDTOresponse;
import com.antonypalomino.model.Cliente;
import com.antonypalomino.repository.ClienteRepository;

public class ClienteServicelmpl implements ClienteService  {
	
	
	private ClienteRepository repoCliente;

	@Override
	public void guardarCliente(ClienteDTORequest Cliente) {
		Cliente p = new Cliente();
		p.setNombre(Cliente.getNombre());
		p.setDireccion(Cliente.getDireccion());
		p.setDni(Cliente.getDni());
		repoCliente.save(p);
	}

	@Override
	public void actualizarCliente(ClienteDTORequest Cliente) {
		// TODO Auto-generated method stub
		Cliente p = new Cliente();
		p.setNombre(Cliente.getNombre());
		p.setDireccion(Cliente.getDireccion());
		p.setDni(Cliente.getDni());
		repoCliente.saveAndFlush(p);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repoCliente.deleteById(id);
	}

	@Override
	public List<ClienteDTOresponse> listarCLiente() {
		List<ClienteDTOresponse> listar = new ArrayList<>();
		
		ClienteDTOresponse dto = null;
		
		List<Cliente> p = repoCliente.findAll();
		
		for (Cliente cliente : p) {
			
			dto = new ClienteDTOresponse();
			
			dto.setNombre(cliente.getNombre());
			dto.setDireccion(cliente.getDireccion());
			dto.setDni(cliente.getDni());

			
			listar.add(dto);
		}
		
		return listar;
	}
	

	@Override
	public ClienteDTOresponse obtenercliente(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente = repoCliente.findById(id).orElse(null);
		ClienteDTOresponse dto = new ClienteDTOresponse();
		
		
		dto.setNombre(cliente.getNombre());
		dto.setDireccion(cliente.getDireccion());
		dto.setDni(cliente.getDni());

		return dto;
	}



}
