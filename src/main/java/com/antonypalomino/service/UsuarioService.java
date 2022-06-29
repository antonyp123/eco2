package com.antonypalomino.service;

import java.util.List;

import com.antonypalomino.dto.UsuarioDTOrequest;
import com.antonypalomino.dto.UsuarioDTOrespose;



public interface UsuarioService {
	
	void guardarUusario(UsuarioDTOrequest usuario);
	void actualizarUsuario(UsuarioDTOrequest usuario);
	void eliminarUsuairo(Integer id);
	List<UsuarioDTOrespose> listarUsuario();
	UsuarioDTOrespose obtenerUsuariosId(Integer id);
}
