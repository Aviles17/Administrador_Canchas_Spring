package com.web.proyectocanchasg1.modelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GrupoRepository extends CrudRepository<Grupo,Long>{
    @Query("SELECT g FROM Grupo g WHERE g.reserva.id_reserva = :id")
    List<Grupo> findbyIdReserva(@Param("id") Long id);
}
