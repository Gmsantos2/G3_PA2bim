/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Jugador;
import DAT.DATJugador;
import interfaz.Login;
import interfaz.Menu_admin;
import interfaz.PantallaCoach;
import interfaz.PantallaJugador;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Juca
 */
public class LogLogin {

    public Jugador IngresarJugador(String user, String pass, Login login) throws ClassNotFoundException, SQLException, ParseException {

        LogJugador ObjImport = new LogJugador();
        Jugador ObjJugador = ObjImport.ImportarJugador(user);
        if (ObjJugador.getEstado()) {
            if (user.equals(ObjJugador.getCedula()) && pass.equals(ObjJugador.getContraseña())) {
                login.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido\n"
                        + "Acceso Correcto", "",
                        JOptionPane.INFORMATION_MESSAGE);

                if (ObjJugador.getFuncion() == 1) {
                    PantallaJugador ObjPantallaJ = new PantallaJugador(ObjJugador);
                    ObjPantallaJ.setVisible(true);
                    login.setVisible(false);

                } else {
                    if (ObjJugador.getFuncion() == 2) {
                        PantallaCoach ObjPantallaC = new PantallaCoach(ObjJugador);
                        ObjPantallaC.setVisible(true);
                        login.setVisible(false);
                    }
                    if (ObjJugador.getFuncion() == 3) {
                        Menu_admin ObjPantallaAdmin = new Menu_admin();
                        ObjPantallaAdmin.setVisible(true);
                        login.setVisible(false);
                    }

                }

            } else {

                JOptionPane.showMessageDialog(null, "Por favor ingrese un usuario y/o contraseña correctos", "",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en el sistema", "",
                    JOptionPane.ERROR_MESSAGE);
        }

        return ObjJugador;

    }

}
