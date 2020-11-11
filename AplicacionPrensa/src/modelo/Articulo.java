/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Articulo {
    
    int codigo;
    String nombre;
    String tipo;
    int valor;
    int promociones;
    int noCupones;
    String caracteristicas;
    
    public Articulo(int codigo, String nombre, String tipo, int valor, int promociones, int noCupones, String caracteristicas){
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.promociones = promociones;
        this.noCupones = noCupones;
        this.caracteristicas = caracteristicas;
    }
    
    public Articulo(int codigo, String nombre, String tipo,int promociones, int noCupones, String caracteristicas){
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.promociones = promociones;
        this.noCupones = noCupones;
        this.caracteristicas = caracteristicas;
    }
    
    public Articulo(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPromociones() {
        return promociones;
    }

    public void setPromociones(int promociones) {
        this.promociones = promociones;
    }

    public int getNoCupones() {
        return noCupones;
    }

    public void setNoCupones(int noCupones) {
        this.noCupones = noCupones;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", valor=" + valor + ", promociones=" + promociones + ", noCupones=" + noCupones + ", caracteristicas=" + caracteristicas + '}';
    }
    
    public Articulo buscarArticulo(String sql){
        
        //Declaracion de objetos
        Articulo art = null;
        ResultSet rs;
        BaseDatos obj = new BaseDatos();
        
        //Declaracion de variables
        int codArt;
        String nameArt;
        String typeArt;
        int amountArt = 0;
        int promocionesArt;
        int noCuponesArt;
        String caracteristicasArt;
        
        
        try{
            if(obj.crearConexion()){
                Statement statement = obj.getConexion().createStatement();
                rs = statement.executeQuery(sql);
                
                while(rs.next()){
                    codArt = rs.getInt("codigo");
                    nameArt = rs.getString("nombre");
                    typeArt = rs.getString("tipo");
                    if(rs.getInt("valor_real")>=0){
                        amountArt = rs.getInt("valor_real");
                    }
                    promocionesArt = rs.getInt("valor_promocion");
                    noCuponesArt = rs.getInt("numero_cupones");
                    caracteristicasArt = rs.getString("caracteristicas");
                    if(amountArt!=0){
                        art = new Articulo(codArt,nameArt,typeArt,amountArt,promocionesArt,noCuponesArt,caracteristicasArt);
                    }
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return art;
    }
    
}
