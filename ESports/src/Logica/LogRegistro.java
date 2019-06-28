/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Jugador;
import Clases.Registro;
import DAT.DATRegistro;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Carlos Juca
 */
public class LogRegistro {

    static DATRegistro objDATRegistro = new DATRegistro();
    static Registro ObjRegistro = new Registro();
    static ArrayList<Registro> arrayRegistros = new ArrayList<>();

    public static ArrayList<Registro> ImportarRegistros(String Cedula) throws ClassNotFoundException, SQLException, ParseException {
        ResultSet rs;
        arrayRegistros.clear();
        rs = objDATRegistro.ConsultarRegistroJugador(Cedula);
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
            Registro e = new Registro();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idregistro")) {
                    e.setIdRegistro(Integer.parseInt(value));
                }
                if (columnName.equals("fecha")) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                    String dateInString = value;
                    Date date = formatter.parse(dateInString);
                    e.setFecha(date);
                }
            }
            arrayRegistros.add(e);
        }
        return arrayRegistros;
    }

    public void crearRegistro(Jugador ObjJugador,Date fecha) {
        ObjJugador.agregarRegistro(fecha);
    }

    public void AgregarRegistro(Jugador ObjJugador) throws SQLException, ClassNotFoundException {
        
        DATRegistro ObjDATRegistro = new DATRegistro();
        ObjRegistro = ObjJugador.registros.get(ObjJugador.registros.size()-1);
        ObjDATRegistro.InsertarRegistro(ObjRegistro, ObjJugador);
    }

    public boolean validarFecha(Jugador ObjJugador, Date fecha) throws ClassNotFoundException, SQLException {

        System.out.println(fecha);
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
        DATRegistro objDATRegistro = new DATRegistro();
        ResultSet rs = objDATRegistro.ConsultarUltimoRegistro(ObjJugador.getIdJugador());
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        String lastDate;
        char[] lastDateTmp = new char[10];
        while (rs.next()) {
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("fecha")) {

                    for (int i = 0; i < 10; i++) {
                        lastDateTmp[i] = value.charAt(i);
                    }
                }
            }
        }
        lastDate = String.valueOf(lastDateTmp);
        System.out.println(lastDate);
        if (objSDF.format(fecha).equals(lastDate)) {
            return true;
        }
        return false;
    }
}
