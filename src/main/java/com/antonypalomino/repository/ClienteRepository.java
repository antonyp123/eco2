package com.antonypalomino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.antonypalomino.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {

}
