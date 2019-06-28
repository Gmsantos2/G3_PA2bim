/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Equipo;
import Clases.Jugador;
import Clases.Partida;
import Clases.Registro;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author isral
 */
public class LogEquipo {

    LogJugador objLogJugador = new LogJugador();
    Jugador ObjJugador = new Jugador();
    
    
    public Equipo Crear(String nombre, ArrayList<Jugador> jugadores){
        Equipo ObjEquipo = new Equipo(nombre, jugadores);
        return ObjEquipo;
    }

    public ArrayList<Jugador> DefinirEquipo() throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<Jugador> listaJugador = objLogJugador.ConsultarJugadores();
        ArrayList<Jugador> listJugador = new ArrayList<>();
        ArrayList<Jugador> TOP = new ArrayList<>();
        ArrayList<Jugador> JG = new ArrayList<>();
        ArrayList<Jugador> MID = new ArrayList<>();
        ArrayList<Jugador> ADC = new ArrayList<>();
        ArrayList<Jugador> SUP = new ArrayList<>();

        for (Jugador ObjJugador : listaJugador) {
            if (ObjJugador.getPosicion().equals("Top")) {
                TOP.add(ObjJugador);
            } else if (ObjJugador.getPosicion().equals("Jungla")) {
                JG.add(ObjJugador);
            } else if (ObjJugador.getPosicion().equals("Mid")) {
                MID.add(ObjJugador);
            } else if (ObjJugador.getPosicion().equals("ADCarry")) {
                ADC.add(ObjJugador);
            } else {
                SUP.add(ObjJugador);
            }
        }

        for (Jugador ObjJugador : TOP) {
            double indKDA = 0;
            objLogJugador.ImportarJugador(ObjJugador.getCedula());
            ArrayList<Registro> list_Registro = ObjJugador.registros;
            for (Registro ObjRegistro : list_Registro) {
                ArrayList<Partida> list_Partida = ObjRegistro.partidas;
                for (Partida ObjPartida : list_Partida) {
                    indKDA += (ObjPartida.getAsesinatos() + ObjPartida.getAsistencias()) / ObjPartida.getMuertes();
                    ObjJugador.setIndKDA(Double.toString(indKDA));
                }
            }
        }
        for (Jugador ObjJugador : JG) {
            double indKDA = 0;
            objLogJugador.ImportarJugador(ObjJugador.getCedula());
            ArrayList<Registro> list_Registro = ObjJugador.registros;
            for (Registro ObjRegistro : list_Registro) {
                ArrayList<Partida> list_Partida = ObjRegistro.partidas;
                for (Partida ObjPartida : list_Partida) {
                    indKDA += (ObjPartida.getAsesinatos() + ObjPartida.getAsistencias()) / ObjPartida.getMuertes();
                    ObjJugador.setIndKDA(Double.toString(indKDA));;
                }
            }
        }
        for (Jugador ObjJugador : MID) {
            double indKDA = 0;
            objLogJugador.ImportarJugador(ObjJugador.getCedula());
            ArrayList<Registro> list_Registro = ObjJugador.registros;
            for (Registro ObjRegistro : list_Registro) {
                ArrayList<Partida> list_Partida = ObjRegistro.partidas;
                for (Partida ObjPartida : list_Partida) {
                    if (ObjPartida.getMuertes() == 0) {
                        ObjPartida.setMuertes(1);
                    }
                    indKDA += (ObjPartida.getAsesinatos() + ObjPartida.getAsistencias()) / ObjPartida.getMuertes();
                    ObjJugador.setIndKDA(Double.toString(indKDA));
                }
            }
        }
        for (Jugador ObjJugador : ADC) {
            double indKDA = 0;
            objLogJugador.ImportarJugador(ObjJugador.getCedula());
            ArrayList<Registro> list_Registro = ObjJugador.registros;
            for (Registro ObjRegistro : list_Registro) {
                ArrayList<Partida> list_Partida = ObjRegistro.partidas;
                for (Partida ObjPartida : list_Partida) {
                    indKDA += (ObjPartida.getAsesinatos() + ObjPartida.getAsistencias()) / ObjPartida.getMuertes();
                    ObjJugador.setIndKDA(Double.toString(indKDA));
                }
            }
        }
        for (Jugador ObjJugador : SUP) {
            double indKDA = 0;
            objLogJugador.ImportarJugador(ObjJugador.getCedula());
            ArrayList<Registro> list_Registro = ObjJugador.registros;
            for (Registro ObjRegistro : list_Registro) {
                ArrayList<Partida> list_Partida = ObjRegistro.partidas;
                for (Partida ObjPartida : list_Partida) {
                    indKDA += (ObjPartida.getAsesinatos() + ObjPartida.getAsistencias()) / ObjPartida.getMuertes();
                    ObjJugador.setIndKDA(Double.toString(indKDA));
                }
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Jugador> dataPorTop = new ArrayList<>();
        dataPorTop.addAll(TOP); 
        Collections.sort(dataPorTop, 
                (o1, o2) -> o1.indKDA.compareTo(o2.indKDA));
        listJugador.add(TOP.get(0));
        //////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Jugador> dataPorJg = new ArrayList<>(); 
        dataPorJg.addAll(JG); 
        Collections.sort(dataPorJg, 
                (o1, o2) -> o1.indKDA.compareTo(o2.indKDA));

        listJugador.add(JG.get(0));
        //////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Jugador> dataPorMid = new ArrayList<>(); 
        dataPorMid.addAll(MID); 
        Collections.sort(dataPorMid, 
                (o1, o2) -> o1.indKDA.compareTo(o2.indKDA));
        listJugador.add(MID.get(0));
        //////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Jugador> dataPorAdc = new ArrayList<>(); 
        dataPorAdc.addAll(ADC); 
        Collections.sort(dataPorAdc, 
                (o1, o2) -> o1.indKDA.compareTo(o2.indKDA));
        listJugador.add(ADC.get(0));
        //////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Jugador> dataPorSupp = new ArrayList<>(); 
        dataPorSupp.addAll(SUP); 
        Collections.sort(dataPorSupp, 
                (o1, o2) -> o1.indKDA.compareTo(o2.indKDA));
        listJugador.add(SUP.get(0));
        //////////////////////////////////////////////////////////////////////////////////////////////////        


        return listJugador;
    }
}
