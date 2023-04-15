package com.web.proyectocanchasg1;

import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoCanchasG1ApplicationTests {

    @Autowired
    CanchasRepository canchasRepository;

    @Test
    void contextLoads() {
    }

}
