package com.web.proyectocanchasg1;

import com.web.proyectocanchasg1.modelo.Equipo;
import com.web.proyectocanchasg1.service.EquipoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EquipoTest {

    @Autowired
    private EquipoService equipoService;


    @Test
    public void pruebaEquipo(){
        try{
            Boolean compInsercion = false;
            Iterator<Equipo> equipos = equipoService.findAll().iterator();
            int cantidad = 0;
            while(equipos.hasNext() ) {
                equipos.next();
                cantidad ++;
            }
            Equipo e1 = new Equipo("Deportivo Tapitas");
            equipoService.save(e1);
            e1 = new Equipo("FC Ballenita");
            equipoService.save(e1);
            e1 = new Equipo("Pequeños Gigantes");
            equipoService.save(e1);

            equipos = equipoService.findAll().iterator();
            int nuevaCantidad = 0;
            while(equipos.hasNext() ) {
                equipos.next();
                nuevaCantidad ++;
            }

            List<Equipo> res = equipoService.findByNameE("Deportivo Tapitas");

            if(cantidad + 3 == nuevaCantidad && res.size() == 1){
                compInsercion = true;
            }
            assertTrue(compInsercion, "Aumento en la cantidad debida y Metodo personalizado funciona" );
        }
        catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Error en la aplicación");
        }
    }
}
