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
import java.util.ArrayList;

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
    String SQL = "INSERT INTO detallecompra (`cdproducto`, `cantidad`, `precio`, `subtotal`, `cdcompra`) VALUES (?,?,?,?,?) ";
        try {
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, dc.getCdproducto());
        pst.setFloat(2, dc.getCantidad());
        pst.setFloat(3, dc.getPrecio());
        pst.setFloat(4, dc.getSubtotal());
        pst.setInt(5, dc.getCdcompra());
        pst.execute();
        } catch (SQLException ex) {
            System.out.println("error detalle:"+ex.toString());
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
    public boolean actualizar(float cantidad, String cod){
        String SQL = "UPDATE productos SET stock = ? WHERE cdproducto = ?";
        //IF NEW.piezas == 0 THEN
//SET NEW.piezas = @derivados.piezas WHERE derivados.codigo = cdproducto
//END IF
        try {
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setFloat(1, cantidad);
        pst.setString(2, cod);
        pst.execute();
        return true;
        } catch (SQLException ex) {
            System.out.println(""+ex);
            return false;
        }
    
    }
        public ArrayList ListarCompras(String from, String till) throws SQLException{
    ArrayList<Compra> ListaC = new ArrayList();
    String SQL = "SELECT * FROM `compras` WHERE `fecha` BETWEEN '"+from+"' AND '"+till+"'";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        while(rs.next()){
        Compra cp = new Compra();
        cp.setCdcompra(rs.getInt("cdcompra"));
        cp.setFecha(rs.getString("fecha"));
        cp.setVendedor(rs.getString("vendedor"));
        cp.setTotal(rs.getFloat("total"));
        ListaC.add(cp);
        }
    }
    catch(SQLException e){
        System.out.println(""+e.getMessage());
    }
    return ListaC;
    }
}
