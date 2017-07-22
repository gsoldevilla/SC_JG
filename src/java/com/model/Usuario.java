/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;

/**
 *
 * @author Java-Sab
 */
public class Usuario {

    private int codigo;
    private String nombres;
    private String apellidos;
    private Date fecNac;
    private String email;
    private int codigoDis;
    private int codigoProv;
    private int codigoDep;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getCodigoDis() {
        return codigoDis;
    }

    public void setCodigoDis(int codigoDis) {
        this.codigoDis = codigoDis;
    }
    
    public int getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(int codigoProv) {
        this.codigoProv = codigoProv;
    }
    
    public int getCodigoDep() {
        return codigoDep;
    }

    public void setCodigoDep(int codigoDep) {
        this.codigoDep = codigoDep;
    }

    @Override
    public String toString() {
        return "User [userid=" + codigo + ", firstName=" + nombres
                + ", lastName=" + apellidos + ", dob=" + fecNac + ", email="
                + email + ", codigoDis=" + codigoDis + ", codigoProv="
                + codigoProv + ", codigoDep=" + codigoDep +"]";
    }

}
