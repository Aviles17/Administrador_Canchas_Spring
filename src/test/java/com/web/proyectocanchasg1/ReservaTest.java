package com.web.proyectocanchasg1;

import com.web.proyectocanchasg1.modelo.*;
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
    @Autowired
    private CanchasRepository canchasRepository;

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
            Canchas Cr = new Canchas("ReservaC",7,23,"02/03/22");
            canchasRepository.save(Cr);

            List<Usuario> Ureserva = usuarioRepository.findByName("Reservas1");
            List<Canchas> CReserva = canchasRepository.findByName("ReservaC");

            Reservas r = new Reservas("01/02/2023",12,4,Ureserva.get(0),CReserva.get(0));

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
