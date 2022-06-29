package com.antonypalomino.service;

import java.util.ArrayList;
import java.util.List;

import com.antonypalomino.dto.UsuarioDTOrequest;
import com.antonypalomino.dto.UsuarioDTOrespose;
import com.antonypalomino.model.Usuario;
import com.antonypalomino.repository.UsuarioRepository;

public class UsuarioServicelmpl implements UsuarioService {
	
	private UsuarioRepository repousu;

	@Override
	public void guardarUusario(UsuarioDTOrequest usuario) {
		Usuario p = new Usuario();
		p.setUsuario(usuario.getUsuario());
		p.setPassword(usuario.getPassword());
		p.setRol(usuario.getRol());

		repousu.save(p);
		
	}

	@Override
	public void actualizarUsuario(UsuarioDTOrequest usuario) {
		Usuario p = new Usuario();
		p.setUsuario(usuario.getUsuario());
		p.setPassword(usuario.getPassword());
		p.setRol(usuario.getRol());
		repousu.saveAndFlush(p);
		
	}

	@Override
	public void eliminarUsuairo(Integer id) {
		// TODO Auto-generated method stub
		repousu.deleteById(id);
		
	}

	@Override
	public List<UsuarioDTOrespose> listarUsuario() {
	List<UsuarioDTOrespose> listar = new ArrayList<>();
		
		UsuarioDTOrespose dto = null;
		
		List<Usuario> p = repousu.findAll();
		
		for (Usuario usuario : p) {
			
			dto = new UsuarioDTOrespose();
			
			dto.setUsuario(usuario.getUsuario());
			dto.setPassword(usuario.getPassword());
			dto.setRol(usuario.getRol());

			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioDTOrespose obtenerUsuariosId(Integer id) {
		Usuario usuario = repousu.findById(id).orElse(null);
		UsuarioDTOrespose dto = new UsuarioDTOrespose();
		
		dto.setUsuario(usuario.getUsuario());
		dto.setPassword(usuario.getPassword());
		dto.setRol(usuario.getRol());
		
		return dto;
	}


}
