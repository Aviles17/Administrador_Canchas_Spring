package com.web.proyectocanchasg1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class IdCanchasTest {

    @Autowired
    CanchasRepository canchasRepository;

    @Test
    public void pruebaLecturaCancha(){
        try{
            Canchas cancha = canchasRepository.findById((long) 2).get();
            canchasRepository.save(cancha);
            assertTrue(cancha.getNombre().equals("C2"));
        }
        catch (Exception e){
            e.printStackTrace();
            assertTrue( false, "Error en la aplicación" );
        }
    }
}
