package com.web.proyectocanchasg1;

import com.web.proyectocanchasg1.modelo.Reservas;
import com.web.proyectocanchasg1.modelo.ReservasRepository;
import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.modelo.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReservaTest {
    @Autowired
    private ReservasRepository reservasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void reservaTest(){
        try{
            Boolean compInsercion = false;
            Iterator<Reservas> reservas = reservasRepository.findAll().iterator();
            int cantidad = 0;
            while(reservas.hasNext() ) {
                reservas.next();
                cantidad ++;
            }

            Usuario UsR = new Usuario("Reservas1", "Hola");
            usuarioRepository.save(UsR);

            List<Usuario> Ureserva = usuarioRepository.findByName("Reservas1");

            Reservas r = new Reservas("01/02/2023","12:00","4:00",Ureserva.get(0));

            reservasRepository.save(r);

            reservas = reservasRepository.findAll().iterator();
            int cantidad_nueva = 0;
            while(reservas.hasNext() ) {
                reservas.next();
                cantidad_nueva ++;
            }
            List<Reservas> res = reservasRepository.findbyUserName("Reservas1");

            if(cantidad + 1 == cantidad_nueva && res.size() == 1){
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
