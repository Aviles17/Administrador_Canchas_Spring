package com.web.proyectocanchasg1.service;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CanchasService implements CanchasRepository{
    @Autowired
    private CanchasRepository canchasRepository;

    @Override
    public <S extends Canchas> S save(S entity) {
        return canchasRepository.save(entity);
    }

    @Override
    public <S extends Canchas> Iterable<S> saveAll(Iterable<S> entities) {
        return canchasRepository.saveAll(entities);
    }

    @Override
    public Optional<Canchas> findById(Long aLong) {
        return canchasRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return canchasRepository.existsById(aLong);
    }

    @Override
    public Iterable<Canchas> findAll() {
        return canchasRepository.findAll();
    }

    @Override
    public Iterable<Canchas> findAllById(Iterable<Long> longs) {
        return canchasRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return canchasRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        canchasRepository.deleteById(aLong);
    }

    @Override
    public void delete(Canchas entity) {
        canchasRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        canchasRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Canchas> entities) {
        canchasRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        canchasRepository.deleteAll();
    }

    public List<Canchas> findByName(String name) {
        List<Canchas> res = new ArrayList<>();
        Iterable<Canchas> temp = canchasRepository.findAll();
        for(Canchas c: temp){
            if(c.getNombre().equalsIgnoreCase(name)){
                res.add(c);
            }
        }
        return res;
    }
}
