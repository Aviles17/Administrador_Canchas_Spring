package com.web.proyectocanchasg1.service;

import com.web.proyectocanchasg1.modelo.Gestion;
import com.web.proyectocanchasg1.modelo.GestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestionService implements GestionRepository{
    @Autowired
    private GestionRepository gestionRepository;

    @Override
    public <S extends Gestion> S save(S entity) {
        return gestionRepository.save(entity);
    }

    @Override
    public <S extends Gestion> Iterable<S> saveAll(Iterable<S> entities) {
        return gestionRepository.saveAll(entities);
    }

    @Override
    public Optional<Gestion> findById(Long aLong) {
        return gestionRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return gestionRepository.existsById(aLong);
    }

    @Override
    public Iterable<Gestion> findAll() {
        return gestionRepository.findAll();
    }

    @Override
    public Iterable<Gestion> findAllById(Iterable<Long> longs) {
        return gestionRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return gestionRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        gestionRepository.deleteById(aLong);
    }

    @Override
    public void delete(Gestion entity) {
        gestionRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        gestionRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Gestion> entities) {
        gestionRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        gestionRepository.deleteAll();
    }
}
