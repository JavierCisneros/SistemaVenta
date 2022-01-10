/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author yopri
 */
public class ProductosDB {
    Conexion conexion;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public boolean agregarP(Productos pro){
    String SQL = "INSERT INTO `productos`(`cdproducto`, `name`, `detalle`, `udm`, `precio`, `base`) VALUES (?,?,?,?,?,?)";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, pro.getCd());
        pst.setString(2, pro.getName());
        pst.setString(3, pro.getDetalle());
        pst.setInt(4, pro.getUdm());
        pst.setFloat(5, pro.getPrecio());
        pst.setFloat(6, pro.getBase());
        pst.executeUpdate();
        return true;
    }
    catch(Exception ex){
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
    public boolean eliminarP(int id){
    String SQL = "DELETE FROM productos WHERE cdproducto = ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, id);
        pst.execute();
        return true;
    }
    catch(SQLException e){
    
        System.out.println(""+ e.toString());
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
    public boolean editarP(Productos pro){
    String SQL = "UPDATE `productos` SET `cdproducto`= ?,`name`= ?,`detalle`= ?,`udm`= ?,`precio`= ?,`base`= ? WHERE `cdproducto`= ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, pro.getCd());
        pst.setString(2, pro.getName());
        pst.setString(3, pro.getDetalle());
        pst.setInt(4, pro.getUdm());
        pst.setFloat(5, pro.getPrecio());
        pst.setFloat(6, pro.getBase());
        pst.setInt(7, pro.getCd() );
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
    public ArrayList ListarProductos() throws SQLException{
    ArrayList<Productos> ListaP = new ArrayList();
    String SQL = "SELECT * FROM productos";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        while(rs.next()){
        Productos pd = new Productos();
        pd.setCd(rs.getInt("cdproducto"));
        pd.setName(rs.getString("name"));
        pd.setDetalle(rs.getString("detalle"));
        pd.setUdm(rs.getInt("udm"));
        pd.setPrecio(rs.getFloat("precio"));
        pd.setBase(rs.getFloat("base"));
        pd.setStock(rs.getFloat("stock"));
        ListaP.add(pd);
        }
    }
    catch(SQLException e){
        System.out.println(""+e.getMessage());
    }
    return ListaP;
    }
    public void ConsulatarProducto(JComboBox productos){
  String SQL = "SELECT cdproducto, name FROM productos ";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        productos.addItem("");
        while(rs.next()){
            productos.addItem(rs.getString("name"));
        }

    }
    catch(SQLException e){
    
        System.out.println(""+ e.toString());
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
     public void ConsulatarCodigos(ArrayList<Integer> codigos){
  String SQL = "SELECT cdproducto, name FROM productos ";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        codigos.add(0);
        while(rs.next()){
            codigos.add(rs.getInt("cdproducto"));
        }

    }
    catch(SQLException e){
    
        System.out.println(""+ e.toString());
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
}
