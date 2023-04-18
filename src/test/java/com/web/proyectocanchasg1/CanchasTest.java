package com.web.proyectocanchasg1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.service.CanchasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CanchasTest {

    @Autowired
    private CanchasService canchasService;

    @Test
    public void pruebaInsercioCancha(){

        try{
            Iterator<Canchas> canchas = canchasService.findAll().iterator();
            int cantidad = 0;
            while(canchas.hasNext() ) {
                canchas.next();
                cantidad ++;
            }
            Canchas cancha = new Canchas("C1",8,21,"01/12/2022");
            canchasService.save(cancha);

            cancha = new Canchas("C2",9,22,"06/06/2020");
            canchasService.save(cancha);

            cancha = new Canchas("C3",6,19,"05/08/2019");
            canchasService.save(cancha);

            canchas = canchasService.findAll().iterator();
            int nuevaCantidad = 0;
            while(canchas.hasNext() ) {
                canchas.next();
                nuevaCantidad ++;
            }
            assertTrue(cantidad + 3 == nuevaCantidad, "Aumento en la cantidad debida" );
        }
        catch (Exception e){
            e.printStackTrace();
            assertTrue( false, "Error en la aplicación" );
        }
    }
}
