/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Jairo
 */
public class PartidaCreada {

    public String tipo;
    public ArrayList<Jugador> equipoAzul = new ArrayList<>();
    public ArrayList<Jugador> equipoRojo = new ArrayList<>();

    public PartidaCreada() {
    }

    public String equipoAzul() {
        String cadena = String.format("NickName - Posición - NivelClasificatoria - Nombres - Apellidos\n");
        for (int i = 0; i < this.equipoAzul.size(); i++) {
            cadena = String.format("%s%s - %s - %s - %s - %s\n", cadena, this.equipoAzul.get(i).getNickname(), this.equipoAzul.get(i).getPosicion(), this.equipoAzul.get(i).getNivelClasificatoria(), this.equipoAzul.get(i).getNombres(), this.equipoAzul.get(i).getApellidos());
        }
        return cadena;
    }

    public String equipoRojo() {
        String cadena = String.format("NickName - Posición - NivelClasificatoria - Nombres - Apellidos\n");
        for (int i = 0; i < this.equipoRojo.size(); i++) {
            cadena = String.format("%s%s - %s - %s - %s - %s\n", cadena, this.equipoRojo.get(i).getNickname(), this.equipoRojo.get(i).getPosicion(), this.equipoRojo.get(i).getNivelClasificatoria(), this.equipoRojo.get(i).getNombres(), this.equipoRojo.get(i).getApellidos());
        }
        return cadena;
    }
    
    public String setTipo(String tipo){
    this.tipo = tipo;
    return tipo;
    }

    public String partida() {
        String cadena = String.format("Partida a jugar:\n\nTipo: %s\n\nEquipo Azul:\n%s\nEquipo Rojo:\n%s\n", this.tipo, this.equipoAzul(), this.equipoRojo());
        return cadena;
    }
}
