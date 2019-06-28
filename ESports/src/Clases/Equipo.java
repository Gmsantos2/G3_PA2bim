package Clases;

import java.util.*;

/**
 *
 */
public class Equipo {

    public String nombre;
    public ArrayList<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombre, ArrayList<Jugador> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    
}
