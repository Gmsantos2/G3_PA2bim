/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Jugador;
import DAT.DATJugador;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Juca
 */
public class LogJugador {

    DATJugador objDATJugador = new DATJugador();

    ArrayList<Jugador> arrayJugadores = new ArrayList<>();

    public ArrayList<Jugador> ConsultarJugadores() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = objDATJugador.ConsultarJugadores();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        //Envia los datos al objeto
        while (rs.next()) {
            Jugador ObjJugador = new Jugador();
//            cedula, nombres, apellidos, contraseña, estado, funcion, posicion,nivelClasificatoria, nickName
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idJugador")) {
                    ObjJugador.setIdJugador(Integer.parseInt(value));
                }
                if (columnName.equals("cedula")) {
                    ObjJugador.setCedula(value);
                }
                if (columnName.equals("nombres")) {
                    ObjJugador.setNombres(value);
                }
                if (columnName.equals("apellidos")) {
                    ObjJugador.setApellidos(value);
                }
                if (columnName.equals("contraseña")) {
                    ObjJugador.setContraseña(value);
                }
                if (columnName.equals("estado")) {
                    if (Integer.parseInt(value) == 1) {
                        ObjJugador.setEstado(true);
                    } else {
                        ObjJugador.setEstado(false);
                    }
                }
                if (columnName.equals("funcion")) {
                    ObjJugador.setFuncion(Integer.parseInt(value));
                }
                if (columnName.equals("posicion")) {
                    ObjJugador.setPosicion(value);
                }
                if (columnName.equals("nivelClasificatoria")) {
                    ObjJugador.setNivelClasificatoria(value);
                }
                if (columnName.equals("nickName")) {
                    ObjJugador.setNickname(value);
                }
            }
            arrayJugadores.add(ObjJugador);
        }
        return arrayJugadores;
    }

    public ResultSet ConsultarPorCedula(String strCedula) throws ClassNotFoundException, SQLException {
        ResultSet rs = objDATJugador.ConsultarPorCedula(strCedula);
        return rs;
    }

    public Jugador ImportarJugador(String user) throws ClassNotFoundException, SQLException, ParseException {
        LogRegistro objLogRegistro = new LogRegistro();
        ResultSet rs;
        rs = objDATJugador.ConsultarPorCedula(user);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        Jugador ObjJugador = new Jugador();
        //Envia los datos al objeto
        while (rs.next()) {

//            cedula, nombres, apellidos, contraseña, estado, funcion, posicion,nivelClasificatoria, nickName
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idjugador")) {
                    ObjJugador.setIdJugador(Integer.parseInt(value));
                }
                if (columnName.equals("cedula")) {
                    ObjJugador.setCedula(value);
                }
                if (columnName.equals("nombres")) {
                    ObjJugador.setNombres(value);
                }
                if (columnName.equals("apellidos")) {
                    ObjJugador.setApellidos(value);
                }
                if (columnName.equals("contraseña")) {
                    ObjJugador.setContraseña(value);
                }
                if (columnName.equals("estado")) {
                    if (Integer.parseInt(value) == 1) {
                        ObjJugador.setEstado(true);
                    } else {
                        ObjJugador.setEstado(false);
                    }
                }
                if (columnName.equals("funcion")) {
                    ObjJugador.setFuncion(Integer.parseInt(value));
                }
                if (columnName.equals("posicion")) {
                    ObjJugador.setPosicion(value);
                }
                if (columnName.equals("nivelClasificatoria")) {
                    ObjJugador.setNivelClasificatoria(value);
                }
                if (columnName.equals("nickName")) {
                    ObjJugador.setNickname(value);
                }
            }
        }
        ObjJugador.setRegistros(objLogRegistro.ImportarRegistros(ObjJugador.getCedula()));
        return ObjJugador;
    }

    public int AgregarJugador(Jugador ObjJugador) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
        intRetorno = objDATJugador.InsertarJugador(ObjJugador);
        return intRetorno;
    }

    public Jugador CambiarContraseña(Jugador ObjJugador, String newPass) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        intRetorno = objDATJugador.CambiarContraseña(ObjJugador, newPass);
        return ObjJugador;
    }

    public Jugador EliminarJugador(Jugador ObjJugador) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        intRetorno = objDATJugador.EliminarJugador(ObjJugador);
        return ObjJugador;
    }

//    ______________________________
//       TRABAJAR CON JSON.TXT
//    _______________________________
    public Jugador CrearJugador(String nickname, String nivelClasificatoria, String posicion, int funcion, String cedula, String nombres, String apellidos, String contraseña) {
        Jugador ObjJugador = new Jugador(nickname, nivelClasificatoria, posicion, funcion, cedula, nombres, apellidos, contraseña);
        return ObjJugador;
    }

    public Jugador actualizarContraseña(Jugador ObjJugador, String nuevaContraseña) {
        ObjJugador.setContraseña(nuevaContraseña);
        return ObjJugador;
    }

    public Jugador eliminarJugador(Jugador ObjJugador) {
        ObjJugador.setEstado(false);
        return ObjJugador;
    }

//    public void actualizarJugador(Jugador ObjJugador) {
//        ExpJugador ObjExpJugador = new ExpJugador();
//        ObjExpJugador.ActualizarJugador(ObjJugador);
//    }
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

}
