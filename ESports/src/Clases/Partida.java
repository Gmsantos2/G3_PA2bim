package Clases;

import java.util.*;

/**
 *
 */
public class Partida {

    public int muertes;
    public int asistencias;
    public int asesinatos;
    public int farm;

    public Partida() {
    }

    public Partida(int muertes, int asistencias, int asesinatos, int farm) {
        this.muertes = muertes;
        this.asistencias = asistencias;
        this.asesinatos = asesinatos;
        this.farm = farm;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getAsesinatos() {
        return asesinatos;
    }

    public void setAsesinatos(int asesinatos) {
        this.asesinatos = asesinatos;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }
    

    @Override
    public String toString() {
        return "Partida{" + "muertes=" + muertes + ", asistencias=" + asistencias + ", asesinatos=" + asesinatos + ", farm=" + farm + '}';
    }
    
    
}
