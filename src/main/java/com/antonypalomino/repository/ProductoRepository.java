package com.antonypalomino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antonypalomino.model.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Integer> {

}
