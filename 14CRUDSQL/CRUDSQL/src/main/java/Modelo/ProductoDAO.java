/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.SQLException;

/**
 *
 * @author demon
 */

import java.sql.*;
import java.util.*;
public class ProductoDAO {
    
    //aqui voy a programar cada comportamiento
    
    public void agregar(Producto prod) throws SQLException, Exception{
        //primero debo de crear su sentencia sql
        String sql = "INSERT INTO producto (id, nombre, precio, cantidad, "
                + "categoria, tipo, fecha_caducidad, es_precedero, peso, marca"
                + "garantia_meses, talla, color, material) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        
        try(
            //primero debes de conectarte al la BD
            Connection con = ConexionBD.getConexion();
            //prepara la sentencia
            PreparedStatement ps = con.prepareStatement(sql)){
                establecerParametroscomunes(ps, prod);
                //establecerParametrosEspecificos(ps,  prod);
                ps.execute();
            }
        
    }

    private void establecerParametroscomunes(
            PreparedStatement ps, Producto prod) throws  Exception{
        
        ps.setInt(1, prod.getId());
        ps.setString(2, prod.getNombre());
        ps.setDouble(3, prod.getPrecio());
        ps.setInt(4, prod.getCantidad());
        ps.setString(5, prod.getCategoria());
        
    }
    
}