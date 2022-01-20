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
public class VentaDB {
        Conexion conexion;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int r;
    public int registrarCompra(Venta v){
    String SQL = "INSERT INTO ventas (total,vendedor) VALUES (?,?)";
        try {    
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setFloat(1, v.getTotal());
        pst.setString(2, v.getVendedor());
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
    public int registarDetalleV(DetalleVenta dv){
    String SQL = "INSERT INTO `detalleventa`( `cdproducto`,`nombre`, `cantidad`, `precio`, `subtotal`, `cdventa`) VALUES  (?,?,?,?,?,?) ";
        try {
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, dv.getCdproducto());
        pst.setString(2, dv.getNombre());
        pst.setFloat(3, dv.getCantidad());
        pst.setFloat(4, dv.getPrecio());
        pst.setFloat(5, dv.getSubtotal());
        pst.setInt(6, dv.getCdventa());
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
    String SQL = "SELECT MAX(cdventa) FROM ventas";
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
    public boolean actualizarStock(float stock, int piezas, String cd){
       String SQL = "UPDATE `productos` SET `stock`= ?,`piezas`= ? WHERE `cdproducto` = ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setFloat(1, stock);
        pst.setInt(2, piezas);
        pst.setString(3, cd);
        pst.executeUpdate();
        return true;
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
        return false;
    }
    finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }
    }
    }
    public boolean actualizarPiezas(int piezas, String cd){
          String SQL = "UPDATE `productos` SET `piezas`= ? WHERE `cdproducto` = ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, piezas);
        pst.setString(2, cd);
        pst.executeUpdate();
        return true;
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
        return false;
    }
    finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }
    }
    }
     public ArrayList ListarVentas(String from, String till) throws SQLException{
    ArrayList<Venta> ListaV = new ArrayList();
    String SQL = "SELECT * FROM `ventas` WHERE `fecha` BETWEEN '"+from+"' AND '"+till+"'";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        while(rs.next()){
        Venta vt = new Venta();
        vt.setCdventa(rs.getInt("cdventa"));
        vt.setFecha(rs.getString("fecha"));
        vt.setVendedor(rs.getString("vendedor"));
        vt.setTotal(rs.getFloat("total"));
        ListaV.add(vt);
        }
    }
    catch(SQLException e){
        System.out.println(""+e.getMessage());
    }
    return ListaV;
    }
}
