/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.*;
import com.util.DBUtil;

/**
 *
 * @author Java-Sab
 */
public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        connection = DBUtil.getConnection();
    }

    public void addUser(Usuario user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into usuario(nombres,apellidos,fecnac,email,codigo_dis,codigo_prov,codigo_dep) values (?, ?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getNombres());
            preparedStatement.setString(2, user.getApellidos());
            preparedStatement.setDate(3, new java.sql.Date(user.getFecNac().getTime()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getCodigoDis());
            preparedStatement.setInt(6, user.getCodigoProv());
            preparedStatement.setInt(7, user.getCodigoDep());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from usuario where codigo=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Usuario user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update usuario set nombres=?, apellidos=?, fecnac=?, email=?, codigo_dis=?, codigo_prov=?, codigo_dep=? where codigo=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getNombres());
            preparedStatement.setString(2, user.getApellidos());
            preparedStatement.setDate(3, new java.sql.Date(user.getFecNac().getTime()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getCodigoDis());
            preparedStatement.setInt(6, user.getCodigoProv());
            preparedStatement.setInt(7, user.getCodigoDep());
            preparedStatement.setInt(8, user.getCodigo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from usuario");
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setCodigo(rs.getInt("codigo"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidos(rs.getString("apellidos"));
                user.setFecNac(rs.getDate("fecnac"));
                user.setEmail(rs.getString("email"));
                user.setCodigoDis(rs.getInt("codigo_dis"));
                user.setCodigoProv(rs.getInt("codigo_prov"));
                user.setCodigoDep(rs.getInt("codigo_dep"));
                users.add(user);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Usuario getUserById(int userId) {
        Usuario user = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where codigo=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setCodigo(rs.getInt("codigo"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidos(rs.getString("apellidos"));
                user.setFecNac(rs.getDate("fecnac"));
                user.setEmail(rs.getString("email"));
                user.setCodigoDis(rs.getInt("codigo_dis"));
                user.setCodigoProv(rs.getInt("codigo_prov"));
                user.setCodigoDep(rs.getInt("codigo_dep"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<Departamento> getAllDepartamentos() {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from departamento");
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(rs.getInt("codigo"));
                departamento.setNombre(rs.getString("nombre"));
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(departamentos.toString());
        return departamentos;
    }

    public List<Provincia> getAllProvincias() {
        List<Provincia> provincias = new ArrayList<Provincia>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from provincia");
            while (rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setCodigo(rs.getInt("codigo"));
                provincia.setNombre(rs.getString("nombre"));
                provincia.setCodigoDep(rs.getInt("codigo_dep"));
                provincias.add(provincia);               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(provincias.toString());
        return provincias;
    }

    public List<Distrito> getAllDistritos() {
        List<Distrito> distritos = new ArrayList<Distrito>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from distrito");
            while (rs.next()) {
                Distrito distrito = new Distrito();
                distrito.setCodigo(rs.getInt("codigo"));
                distrito.setNombre(rs.getString("nombre"));
                distrito.setCodigoDep(rs.getInt("codigo_dep"));
                distrito.setCodigoProv(rs.getInt("codigo_prov"));
                distritos.add(distrito);                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(distritos.toString());
        return distritos;
    }

}
