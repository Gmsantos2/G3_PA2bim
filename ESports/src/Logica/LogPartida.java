/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Jugador;
import Clases.Partida;
import Clases.Registro;
import DAT.DATPartida;
import DAT.DATRegistro;
import java.sql.SQLException;

/**
 *
 * @author Carlos Juca
 */
public class LogPartida {
    
    Partida ObjPartida = new Partida();
    
    public void CrearPartida(int muertes, int asistencias, int asesinatos, int farm, Registro ObjRegistro){
        ObjRegistro.agregarPartida(muertes, asistencias, asesinatos, farm);
    }
    
    public void AgregarPartida(Registro ObjRegistro) throws SQLException, ClassNotFoundException {
        
        DATPartida ObjDATPartida = new DATPartida();
        ObjPartida = ObjRegistro.partidas.get(ObjRegistro.partidas.size()-1);
        ObjDATPartida.InsertarPartida(ObjPartida,ObjRegistro);
    }
    
}
