/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases.Equipo;
import Clases.Partida;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos Juca
 */
public class DATEquipo {
        static DATConexion c = new DATConexion();

    public int InsertarEquipo(Equipo ObjEquipo) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO equipo (nombre)  VALUES ( "
                + "'" + ObjEquipo.getNombre() + ")";
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
}
