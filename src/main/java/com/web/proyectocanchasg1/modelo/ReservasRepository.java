package com.web.proyectocanchasg1.modelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservasRepository extends CrudRepository<Reservas, Long> {
    List<Reservas> findbyUserId(Long id);
}
