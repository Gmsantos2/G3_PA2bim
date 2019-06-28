/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases.Jugador;
import Clases.Partida;
import Clases.Registro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Carlos Juca
 */
public class DATRegistro {

    static DATConexion c = new DATConexion();

    public int InsertarRegistro(Registro ObjRegistro, Jugador ObjJugador) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String lastDate = objSDF.format(ObjRegistro.getFecha());
        String Sentencia = "INSERT InTO registro (fecha, idJugador)  VALUES ( "
                + "'" + lastDate + "'" + ","
                + "'" + ObjJugador.getIdJugador() + "'" + ")";
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }

    public static ResultSet ConsultarUltimoRegistro(int idJugador) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "select * from registro where idJugador ='"
                + idJugador + "' order by idregistro desc limit 1";
        ResultSet rs = st.executeQuery(Sentencia);
        System.out.println(Sentencia);
        return rs;
    }

    public static ResultSet ConsultarRegistroJugador(String Cedula) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "select idRegistro,fecha from jugador j,registro r\n"
                + "where j.idJugador = r.idJugador\n"
                + "and j.cedula = " + Cedula + " order by 1";
        ResultSet rs = st.executeQuery(Sentencia);
        System.out.println(Sentencia);
        return rs;
    }
}
