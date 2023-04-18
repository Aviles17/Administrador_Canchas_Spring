package com.web.proyectocanchasg1.service;

import com.web.proyectocanchasg1.modelo.Equipo;
import com.web.proyectocanchasg1.modelo.EquipoRepository;
import com.web.proyectocanchasg1.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService implements EquipoRepository {
    @Autowired
    EquipoRepository equipoRepository;

    @Override
    public <S extends Equipo> S save(S entity) {
        return equipoRepository.save(entity);
    }

    @Override
    public <S extends Equipo> Iterable<S> saveAll(Iterable<S> entities) {
        return equipoRepository.saveAll(entities);
    }

    @Override
    public Optional<Equipo> findById(Long aLong) {
        return equipoRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return equipoRepository.existsById(aLong);
    }

    @Override
    public Iterable<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Override
    public Iterable<Equipo> findAllById(Iterable<Long> longs) {
        return equipoRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return equipoRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        equipoRepository.deleteById(aLong);
    }

    @Override
    public void delete(Equipo entity) {
        equipoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        equipoRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Equipo> entities) {
        equipoRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        equipoRepository.deleteAll();
    }

    public List<Equipo> findByNameE(String name){
        List<Equipo> res = new ArrayList<>();
        Iterable<Equipo> temp = equipoRepository.findAll();
        for(Equipo e: temp){
            if(e.getNombre().equalsIgnoreCase(name)){
                res.add(e);
            }
        }
        return res;
    }
}
