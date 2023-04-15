package com.web.proyectocanchasg1.modelo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CanchasRepository extends CrudRepository<Canchas, Long> {
    List<Canchas> findByName(String name);
}
