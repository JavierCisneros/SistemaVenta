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
        ListaP.add(pd);
        }
        
    }
    catch(SQLException e){
        System.out.println(""+e.getMessage());
    }
    return ListaP;
    }
}
