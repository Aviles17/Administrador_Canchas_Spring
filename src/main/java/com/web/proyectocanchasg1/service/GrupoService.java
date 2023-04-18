package com.web.proyectocanchasg1.service;

import com.web.proyectocanchasg1.modelo.Grupo;
import com.web.proyectocanchasg1.modelo.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrupoService implements GrupoRepository{
    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public <S extends Grupo> S save(S entity) {
        return grupoRepository.save(entity);
    }

    @Override
    public <S extends Grupo> Iterable<S> saveAll(Iterable<S> entities) {
        return grupoRepository.saveAll(entities);
    }

    @Override
    public Optional<Grupo> findById(Long aLong) {
        return grupoRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return grupoRepository.existsById(aLong);
    }

    @Override
    public Iterable<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Iterable<Grupo> findAllById(Iterable<Long> longs) {
        return grupoRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return grupoRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        grupoRepository.deleteById(aLong);
    }

    @Override
    public void delete(Grupo entity) {
        grupoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        grupoRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Grupo> entities) {
        grupoRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        grupoRepository.deleteAll();
    }
}
