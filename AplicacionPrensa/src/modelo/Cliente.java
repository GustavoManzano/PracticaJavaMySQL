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
public class Cliente {
    
    private String name;
    private int id;
    private String phone;
    
    public Cliente(){
        
    }
    
    public Cliente(String name, int id, String phone){
        this.name = name;
        this.id = id;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "name=" + name + ", id=" + id + ", phone=" + phone + '}';
    }
    
    public Cliente buscarCliente(String sql){
        Cliente cl = null;
        ResultSet rs;
        BaseDatos obj = new BaseDatos();
        
        int idCliente;
        String nameCliente;
        String phoneCliente;
        
        try{
            if(obj.crearConexion()){
                Statement statement = obj.getConexion().createStatement();
                rs = statement.executeQuery(sql);
                
                while(rs.next()){
                    idCliente = rs.getInt("identificacion");
                    nameCliente = rs.getString("nombre");
                    phoneCliente = rs.getString("telefono");
                    cl = new Cliente(nameCliente, idCliente, phoneCliente);
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return cl;
    }
}
