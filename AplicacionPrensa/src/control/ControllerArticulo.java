/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Articulo;
import modelo.BaseDatos;

/**
 *
 * @author Usuario
 */
public class ControllerArticulo {
    
    public boolean insertarArticulo(Articulo obj){
        boolean t = false;
        String sql = "";
        if (Integer.toString(obj.getCodigo()) != null) {
            if(Integer.toString(obj.getValor()) != null){
                sql = "insert into articulos(nombre, tipo, valor_real,valor_promocion,numero_cupones,caracteristicas,codigo) values('" + obj.getNombre() + "','" + obj.getTipo() + "'," + obj.getValor() + "," + obj.getPromociones() + "," + obj.getNoCupones() + ", '" + obj.getCaracteristicas() + "', " + obj.getCodigo() + ");";
            }
            else{
                sql = "insert into articulos(nombre, tipo, valor_promocion,numero_cupones,caracteristicas,codigo) values('" + obj.getNombre() + "','" + obj.getTipo() + "," + obj.getPromociones() + "," + obj.getNoCupones() + ", '" + obj.getCaracteristicas() + "', " + obj.getCodigo() + ");";
            }
        }
        BaseDatos db = new BaseDatos();
        t = db.insertDatos(sql);
        
        return t;
    }
    
    public Articulo buscarArticulo(int codigo){
        Articulo art = new Articulo();
        String sql = "select * from articulos where codigo = " + codigo + ";";
        Articulo articulo = art.buscarArticulo(sql);
        return articulo;
    }
}
