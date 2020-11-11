/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author Usuario
 */
public class BaseDatos {
    
    Connection conexion;
    Statement stm;
    
    public BaseDatos(){  
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public boolean crearConexion(){
        boolean t = true;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/prensa";
            String usuario = "root";
            String pass = "root";
            conexion = DriverManager.getConnection(url, usuario, pass);
            stm = conexion.createStatement();
            t = true;
            
        }
        catch(SQLException e){
            t = false;
            System.out.println("Erro de MySQL: " + e.toString());
        }
        catch(ClassNotFoundException e){
            t = false;
            System.out.println("Error de archivo no encontrado: " + e.toString());
        }
        return t;
    }
    
    public boolean insertDatos(String sql){
        boolean t = false;
        BaseDatos obj = new BaseDatos();
        try{
            if (obj.crearConexion()) {
                try (Statement sentencia = obj.getConexion().createStatement()) {
                    sentencia.executeUpdate(sql);
                }
                t = true;
            }
        }
        catch(SQLException e){
            t = false;
            System.out.println("Erro " + e.toString());
        }
        return t;
    }    
}
