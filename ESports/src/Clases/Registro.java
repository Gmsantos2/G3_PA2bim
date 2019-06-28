package Clases;

import java.util.*;

/**
 *
 */
public class Registro {

    public int idRegistro;
    public Date fecha;
    public ArrayList<Partida> partidas = new ArrayList<>();

    public Registro() {
    }

    public Registro(Date fecha) {
        this.fecha = fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public void agregarPartida(int muertes, int asistencias, int asesinatos, int farm) {
        this.partidas.add(new Partida(muertes, asistencias, asesinatos, farm));
    }

    @Override
    public String toString() {
        return "Registro{" + "fecha=" + fecha + ", partidas=" + partidas + '}';
    }

}
