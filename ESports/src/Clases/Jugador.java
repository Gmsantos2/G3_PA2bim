package Clases;

import Clases.Miembro;
import java.util.*;

/**
 *
 */
public class Jugador extends Miembro {

    public int idJugador;
    public String nickname;
    public String nivelClasificatoria;
    public String posicion;
    public int funcion;
    public boolean estado;
    public String indKDA;
    public ArrayList<Registro> registros = new ArrayList<>();

    public Jugador() {
    }

    public Jugador(String nickname, String nivelClasificatoria, String posicion, int funcion, String cedula, String nombres, String apellidos, String contraseña) {
        super(cedula, nombres, apellidos, contraseña);
        this.nickname = nickname;
        this.nivelClasificatoria = nivelClasificatoria;
        this.posicion = posicion;
        this.funcion = funcion;
        this.estado = true;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNivelClasificatoria() {
        return nivelClasificatoria;
    }

    public void setNivelClasificatoria(String nivelClasificatoria) {
        this.nivelClasificatoria = nivelClasificatoria;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getFuncion() {
        return funcion;
    }

    public void setFuncion(int funcion) {
        this.funcion = funcion;
    }

    public String getCedula() {
        return cedula;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getIndKDA() {
        return indKDA;
    }

    public void setIndKDA(String indKDA) {
        this.indKDA = indKDA;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
    
    
    public Jugador(String nickname, String nivelClasificatoria, String posicion, int funcion, boolean estado, String indKDA) {
        this.nickname = nickname;
        this.nivelClasificatoria = nivelClasificatoria;
        this.posicion = posicion;
        this.funcion = funcion;
        this.estado = estado;
        this.indKDA = indKDA;
    }
    
    public void agregarRegistro(Date fecha){
       this.registros.add(new Registro(fecha));
    }

    @Override
    public String toString() {
        return "Jugador{" + "nickname=" + nickname + ", nivelClasificatoria=" + nivelClasificatoria + ", posicion=" + posicion + ", funcion=" + funcion + ", estado=" + estado + ", indKDA=" + indKDA + ", registros=" + registros + '}';
    }

    
}
