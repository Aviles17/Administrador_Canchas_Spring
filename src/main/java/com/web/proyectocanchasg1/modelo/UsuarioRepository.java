package com.web.proyectocanchasg1.modelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    List<Usuario> findByName(String name);
}
