package com.web.proyectocanchasg1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String NombreU;

    private String CodedPassword;

    public Usuario(String nombreU, String codedPassword) {
        NombreU = nombreU;
        CodedPassword = codedPassword;
    }

    public Usuario(){
        super();
        NombreU = null;
        CodedPassword = null;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreU() {
        return NombreU;
    }

    public void setNombreU(String nombreU) {
        NombreU = nombreU;
    }

    public String getCodedPassword() {
        return CodedPassword;
    }

    public void setCodedPassword(String codedPassword) {
        CodedPassword = codedPassword;
    }
}
