package com.web.proyectocanchasg1.modelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservasRepository extends CrudRepository<Reservas, Long> {
    @Query("SELECT r FROM Reservas r WHERE r.usuario.NombreU = :Name")
    List<Reservas> findbyUserName(@Param("Name") String Name);

    @Query("SELECT r FROM Reservas r WHERE r.usuario.idUsuario = :id")
    List<Reservas> findbyUserId(@Param("id") Long id);
}
