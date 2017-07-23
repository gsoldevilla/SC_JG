/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Categoria;
import com.model.Producto;
import com.model.SubCategoria;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Java-Sab
 */
public class ProductoDao {
    
    private Connection connection;

    public ProductoDao() {
        connection = DBUtil.getConnection();
    }
    
    public List<Categoria> getAllCategorias() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from categoria");
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("idcategoria"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(categorias.toString());
        return categorias;
    }
    
    public List<SubCategoria> getAllSubCategorias() {
        List<SubCategoria> subCategorias = new ArrayList<SubCategoria>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from sub_categoria");
            while (rs.next()) {
                SubCategoria subCategoria = new SubCategoria();
                subCategoria.setId(rs.getInt("idsub_categoria"));
                subCategoria.setIdCategoria(rs.getInt("idcategoria"));
                subCategoria.setDescripcion(rs.getString("descripcion"));
                subCategorias.add(subCategoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(subCategorias.toString());
        return subCategorias;
    }
    
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<Producto>();
        try {
            System.out.println("**********************************************PASO1");
            Statement statement = connection.createStatement();
            System.out.println("**********************************************PASO2");
            ResultSet rs = statement.executeQuery("select * from producto");
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("idproducto"));
                producto.setIdSubCategoria(rs.getInt("idsub_categoria"));
                producto.setIdCategoria(rs.getInt("idcategoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(productos.toString());
        return productos;
    }
    
}