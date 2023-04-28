package com.web.proyectocanchasg1;

import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.modelo.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UsuarioTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void pruebaUsuario(){
        try{
            Boolean compInsercion = false;
            Iterator<Usuario> users = usuarioRepository.findAll().iterator();
            int cantidad = 0;
            while(users.hasNext() ) {
                users.next();
                cantidad ++;
            }

            Usuario u1 = new Usuario("Aviles", "1234567");
            usuarioRepository.save(u1);
            u1 = new Usuario("Cesar", "Mi_Clave");
            usuarioRepository.save(u1);

            users = usuarioRepository.findAll().iterator();
            int nuevaCantidad = 0;
            while(users.hasNext() ) {
                users.next();
                nuevaCantidad ++;
            }

            List<Usuario> res =usuarioRepository.findByName("Cesar");
            if(cantidad + 2 == nuevaCantidad && res.size() == 1){
                compInsercion = true;
            }
            assertTrue(compInsercion, "Se incertaron correctamente los usuarios");

        }
        catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Error en la aplicación");
        }

    }
}
