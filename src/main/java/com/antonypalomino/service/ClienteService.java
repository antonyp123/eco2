package com.antonypalomino.service;

import java.util.List;

import com.antonypalomino.dto.ClienteDTORequest;
import com.antonypalomino.dto.ClienteDTOresponse;





public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest Cliente);
	void actualizarCliente(ClienteDTORequest Cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOresponse> listarCLiente();
	ClienteDTOresponse obtenercliente(Integer id);
}
	

