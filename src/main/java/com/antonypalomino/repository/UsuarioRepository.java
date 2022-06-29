package com.antonypalomino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonypalomino.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
