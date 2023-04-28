package com.web.proyectocanchasg1.modelo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CanchasRepository extends CrudRepository<Canchas, Long> {

    @Query("SELECT c FROM Canchas c WHERE c.Nombre_canchas = :nombre ")
    List<Canchas> findByName(@Param("nombre") String name);
}
