package com.web.proyectocanchasg1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CanchasTest {
    @Autowired
    CanchasRepository canchasRepository;

    @Test
    public void pruebaInsercioCancha(){

        try{
            Canchas cancha = new Canchas();
            canchasRepository.save(cancha);

            Iterator<Canchas>c = canchasRepository.findAll().iterator();
            int nuevaCantidad = 0;
            while( c.hasNext() ) {
                c.next();
                nuevaCantidad ++;
            }
            assertTrue(  nuevaCantidad ==  2, "Aumento en la cantidad debida" );
        }
        catch (Exception e){
            e.printStackTrace();
            assertTrue( false, "Error en la aplicación" );
        }
    }
}
