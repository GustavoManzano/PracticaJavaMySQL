/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionprensa;

import modelo.BaseDatos;

/**
 *
 * @author Usuario
 */
public class AplicacionPrensa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseDatos obj = new BaseDatos();
        boolean t = obj.crearConexion();
        if (t) {
            System.out.println("Conexión exitosa con la base de datos");
        } else {
            System.out.println("Conexión fallida con la base de datos");
        }

    }

}
