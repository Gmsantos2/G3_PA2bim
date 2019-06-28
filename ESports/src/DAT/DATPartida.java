/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases.Partida;
import Clases.Registro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos Juca
 */
public class DATPartida {

    static DATConexion c = new DATConexion();

    public int InsertarPartida(Partida ObjPartida, Registro ObjRegistro) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO partida (muertes, asistencias, asesinatos,farm, idRegistro)  VALUES ( "
                + "'" + ObjPartida.getMuertes() + "'" + ","
                + "'" + ObjPartida.getAsistencias() + "'" + ","
                + "'" + ObjPartida.getAsesinatos()+ "'" + ","
                + "'" + ObjPartida.getFarm()+ "'" + ","
                + "'" + ObjRegistro.getIdRegistro()+ "'" + ")";
                        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    public static ResultSet ConsultarPartidasJugador(String Cedula) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "select partida.idPartida,muertes,asistencias,asesinatos,farm from jugador, partida "
                + "where jugador.idJugador = partida.idPartida and jugador.cedula = " + Cedula + " order by 1";
        ResultSet rs = st.executeQuery(Sentencia);
        System.out.println(Sentencia);
        return rs;
    }
}
