package com.web.proyectocanchasg1.modelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    @Query("SELECT u FROM Usuario u WHERE u.NombreU = :nombre ")
    List<Usuario> findByName(@Param("nombre") String name);
}
