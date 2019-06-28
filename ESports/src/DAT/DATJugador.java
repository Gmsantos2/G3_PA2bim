/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos Juca
 */
public class DATJugador {

    DATConexion c = new DATConexion();

    public ResultSet ConsultarJugadores() throws ClassNotFoundException, SQLException {

        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM jugador";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public ResultSet ConsultarPorCedula(String strCedula) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM JUGADOR WHERE CEDULA = " + strCedula;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
    public int InsertarJugador(Jugador ObjJugador) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        //INSERT INTO `esports`.`jugador` (`cedula`, `nombres`, `apellidos`, `contraseña`, `estado`, `funcion`, `posicion`, `nivelClasificatoria`, `nickName`) VALUES ('1108', 'Antse', 'Caceres', '1234', '1', '1', 'TOP', 'Hierro', 'Antse123');
        int estado =0;
        if(ObjJugador.getEstado()){
            estado = 1;
        }else{
            estado = 0;
        }
        String Sentencia = "INSERT INTO jugador (cedula,nombres,apellidos,contraseña,estado,funcion,posicion,nivelClasificatoria,nickName)  VALUES ( "
                + "'" + ObjJugador.getCedula() + "'" + ","
                + "'" + ObjJugador.getNombres() + "'" + ","
                + "'" + ObjJugador.getApellidos() + "'" + ","
                + "'" + ObjJugador.getContraseña() + "'" + ","
                + "'" + estado + "'" + ","
                + "'" + ObjJugador.getFuncion() + "'" + ","
                + "'" + ObjJugador.getPosicion() + "'" + ","
                + "'" + ObjJugador.getNivelClasificatoria() + "'" + ","
                + "'" + ObjJugador.getNickname() + "'" + ")";
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }

    public int CambiarContraseña(Jugador ObjJugador, String newPass) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "UPDATE jugador set contraseña = '" + newPass + "'"
                + " where cedula = '" + ObjJugador.getCedula() + "'";
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }

    public int EliminarJugador(Jugador ObjJugador) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "UPDATE jugador set estado = '" + 0 + "'"
                + " where cedula = '" + ObjJugador.getCedula() + "'";
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }

}
