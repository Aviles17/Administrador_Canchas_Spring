package com.web.proyectocanchasg1;

import com.web.proyectocanchasg1.modelo.Equipo;
import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UsuarioTest {
    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void pruebaUsuario(){
        try{
            Boolean compInsercion = false;
            Iterator<Usuario> users = usuarioService.findAll().iterator();
            int cantidad = 0;
            while(users.hasNext() ) {
                users.next();
                cantidad ++;
            }

            Usuario u1 = new Usuario("Aviles", "1234567");
            usuarioService.save(u1);
            u1 = new Usuario("Cesar", "Mi_Clave");
            usuarioService.save(u1);

            users = usuarioService.findAll().iterator();
            int nuevaCantidad = 0;
            while(users.hasNext() ) {
                users.next();
                cantidad ++;
            }

            List<Usuario> res = usuarioService.findByName("Cesar");

            if(cantidad + 3 == nuevaCantidad && res.size() == 1){
                compInsercion = true;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Error en la aplicación");
        }

    }
}
