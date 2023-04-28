package com.web.proyectocanchasg1.modelo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipoRepository extends CrudRepository<Equipo, Long>{
    @Query("SELECT e FROM Equipo e WHERE e.Nombre = :nombre")
    List<Equipo> findByNameE(@Param("nombre") String name);
}
