/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author audiovisual
 */
public class Distrito {

    private int codigo;
    private String nombre;
    private int codigoDep;
    private int codigoProv;

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

    public int getCodigoDep() {
        return codigoDep;
    }

    public void setCodigoDep(int codigoDep) {
        this.codigoDep = codigoDep;
    }

    public int getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(int codigoProv) {
        this.codigoProv = codigoProv;
    }    

    @Override
    public String toString() {
        return "codigo: "+codigo+"| nombre: "+nombre+"| codDep: "+codigoDep+"| codProv: "+codigoProv; //To change body of generated methods, choose Tools | Templates.
    }

}
