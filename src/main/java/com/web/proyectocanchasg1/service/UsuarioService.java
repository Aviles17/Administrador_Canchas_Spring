package com.web.proyectocanchasg1.service;

import com.web.proyectocanchasg1.modelo.Reservas;
import com.web.proyectocanchasg1.modelo.Usuario;
import com.web.proyectocanchasg1.modelo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioRepository {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public <S extends Usuario> S save(S entity) {
        return usuarioRepository.save(entity);
    }

    @Override
    public <S extends Usuario> Iterable<S> saveAll(Iterable<S> entities) {
        return usuarioRepository.saveAll(entities);
    }

    @Override
    public Optional<Usuario> findById(Long aLong) {
        return usuarioRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return usuarioRepository.existsById(aLong);
    }

    @Override
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Iterable<Usuario> findAllById(Iterable<Long> longs) {
        return usuarioRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        usuarioRepository.deleteById(aLong);
    }

    @Override
    public void delete(Usuario entity) {
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        usuarioRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Usuario> entities) {
        usuarioRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    public List<Usuario> findByName(String name){
        List<Usuario> res = new ArrayList<>();
        Iterable<Usuario> temp = usuarioRepository.findAll();
        for(Usuario u: temp){
            if(u.getNombreU().equalsIgnoreCase(name)){
                res.add(u);
            }
        }
        return res;
    }
}
