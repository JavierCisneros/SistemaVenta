/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yopri
 */
public class CompraDB {
    Conexion conexion;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int r;
    public int registrarCompra(Compra c){
    String SQL = "INSERT INTO compras (total) VALUES (?)";
        try {    
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setFloat(1, c.getTotal());
        } catch (SQLException ex) {
            System.out.println(""+ex.toString());
        }
        return r;
    }
}
