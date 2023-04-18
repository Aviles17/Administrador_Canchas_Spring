package com.web.proyectocanchasg1.service;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.Reservas;
import com.web.proyectocanchasg1.modelo.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasService implements ReservasRepository{
    @Autowired
    private ReservasRepository reservasRepository;


    @Override
    public <S extends Reservas> S save(S entity) {
        return reservasRepository.save(entity);
    }

    @Override
    public <S extends Reservas> Iterable<S> saveAll(Iterable<S> entities) {
        return reservasRepository.saveAll(entities);
    }

    @Override
    public Optional<Reservas> findById(Long aLong) {
        return reservasRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return reservasRepository.existsById(aLong);
    }

    @Override
    public Iterable<Reservas> findAll() {
        return reservasRepository.findAll();
    }

    @Override
    public Iterable<Reservas> findAllById(Iterable<Long> longs) {
        return reservasRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return reservasRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        reservasRepository.deleteById(aLong);
    }

    @Override
    public void delete(Reservas entity) {
        reservasRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        reservasRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Reservas> entities) {
        reservasRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        reservasRepository.deleteAll();
    }

    public List<Reservas> findbyUserId(Long id){
        List<Reservas> res = new ArrayList<>();
        Iterable<Reservas> temp = reservasRepository.findAll();
        for(Reservas r: temp){
            if(r.getUsuario().getIdUsuario().equals(id)){
                res.add(r);
            }
        }
        return res;
    }
    public List<Reservas> findbyUserName(String Name){
        List<Reservas> res = new ArrayList<>();
        Iterable<Reservas> temp = reservasRepository.findAll();
        for(Reservas r: temp){
            if(r.getUsuario().getNombreU().equalsIgnoreCase(Name)){
                res.add(r);
            }
        }
        return res;
    }
}
