/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Cliente;
import modelo.BaseDatos;

/**
 *
 * @author Usuario
 */
public class ControllerCliente {

    public boolean insertarCliente(Cliente obj) {
        boolean t = false;
        String sql = "";
        if (Integer.toString(obj.getId()) != null) {
            sql = "insert into clientes(nombre,identificacion,telefono) values('" + obj.getName() + "','" + obj.getId() + "','" + obj.getPhone() + "');";
        }
        BaseDatos db = new BaseDatos();
        t = db.insertDatos(sql);

        return t;
    }

    public Cliente buscarCliente(int id) {
        Cliente cl = new Cliente();
        String sql = "select * from clientes where identificacion = '" + id + "';";
        Cliente objc = cl.buscarCliente(sql);
        return objc;
    }

    public boolean editarCliente(int id, String nombre, String telefono) {
        boolean t = false;
        Cliente cl = new Cliente();
        String sql = "";
        
        if (Integer.toString(id) != null) {
            if (nombre != null && telefono != null) {
                sql = "update clientes set nombre = '" + nombre + "', telefono = '" + telefono + "' where identificacion = " + id + ";";
            }
            if (nombre != null && telefono == null) {
                sql = "update clientes set nombre = '" + nombre + "' where identificacion = " + id + ";";
            }
            if (nombre == null && telefono != null) {
                sql = "update clientes set telegono = '" + telefono + "' where identificacion = " + id + ";";
            }
        }
        
        BaseDatos db = new BaseDatos();
        t = db.insertDatos(sql);
        
        return t;
    }
}
