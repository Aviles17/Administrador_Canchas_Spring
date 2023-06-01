package com.web.proyectocanchasg1.modelo;

import com.amazonaws.util.json.JSONObject;
import com.web.proyectocanchasg1.security.keymanagment;
import jakarta.persistence.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre_Usuario")
    private String NombreU;

    @Column(name = "password")
    private String CodedPassword;

    @Column(name = "token")
    private String JWTtoken;

    public Usuario(String nombreU, String codedPassword) {
        NombreU = nombreU;
        CodedPassword = hashPassword(codedPassword);
        JWTtoken = null;
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

    public String getJWTtoken() {
        return JWTtoken;
    }

    public void setJWTtoken(String JWTtoken) {
        this.JWTtoken = JWTtoken;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jusuario = new JSONObject();
        jusuario.put("id", getIdUsuario());
        jusuario.put("nombre", getNombreU());
        jusuario.put("password", getCodedPassword());
        return jusuario;
    }

    private String hashPassword(String Password){
        String hashedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashedPassword;
    }

    public boolean LogIn(String username, String Password){
        String hashedPassword = hashPassword(Password);
        return this.NombreU.equals(username) && hashedPassword.equals(this.CodedPassword);
    }

    public String getJWTToken(String username, String Password){
        String token = keymanagment.createJWT(username,Password);
        setJWTtoken(token);
        return token;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", NombreU='" + NombreU + '\'' +
                ", CodedPassword='" + CodedPassword + '\'' +
                '}';
    }
}
