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
    String SQL = "INSERT INTO compras (total,vendedor) VALUES (?,?)";
        try {    
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setFloat(1, c.getTotal());
        pst.setString(2, c.getVendedor());
        pst.execute();
        } catch (SQLException ex) {
            System.out.println(""+ex.toString());
        }    finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }    
    }
        return r;
    }
    public int registarDetalleC(DetalleCompra dc){
    String SQL = "INSERT INTO detallecompra (`cdproducto`, `cantidad`, `precio`, `cdcompra`) VALUES (?,?,?,?) ";
        try {
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, dc.getCdproducto());
        pst.setFloat(2, dc.getCantidad());
        pst.setFloat(3, dc.getPrecio());
        pst.setInt(4,dc.getCdcompra());
        pst.execute();
        } catch (SQLException ex) {
            System.out.println(""+ex.toString());
        }
        finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }    
    }
         return r;
    }
    public int idVenta(){
    int id =0;
    String SQL = "SELECT MAX(cdcompra) FROM compras";
        try {
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        
        } catch (SQLException ex) {
            System.out.println(""+ex);
        }
         finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }    
    }
        return id;
    }
    public boolean actualizar(float cantidad, int cod){
        String SQL = "UPDATE productos SET stock = ? WHERE cdproducto = ?";
        try {
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setFloat(1, cantidad);
        pst.setInt(2, cod);
        pst.execute();
        return true;
        } catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
        }
    
    }
}
