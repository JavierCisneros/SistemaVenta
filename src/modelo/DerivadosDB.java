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
import javax.swing.JOptionPane;

/**
 *
 * @author yopri
 */
public class DerivadosDB {
    Conexion conexion;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public boolean agregarD(Derivados der){
    String SQL = "INSERT INTO `derivados`(`codigo`, `nombre`, `cderivado`, `nderivado`, `detalle`, `precio`) VALUES (?,?,?,?,?,?)";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, der.getCd());
        pst.setString(2, der.getNombre());
        pst.setString(3, der.getCderivado());
        pst.setString(4, der.getNderivado());
        pst.setString(5, der.getDetalled());
        pst.setFloat(6, der.getPrecio());
        pst.executeUpdate();
        return true;
    }
    catch(Exception e){
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
    public boolean eliminarD(String id){
    String SQL = "DELETE FROM derivados WHERE cderivado = ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, id);
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
    public boolean editarD(Derivados der){
    String SQL = "UPDATE `derivados` SET `codigo`= ?,`nombre`=?,`cderivado`= ?,`nderivado`= ?,`detalle`= ?,`precio`= ? WHERE `cderivado`= ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, der.getCd());
        pst.setString(2, der.getNombre());
        pst.setString(3, der.getCderivado());
        pst.setString(4, der.getNderivado());
        pst.setString(5, der.getDetalled());
        pst.setFloat(6, der.getPrecio());
        pst.setString(7, der.getCderivado());
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
    public ArrayList ListarProductosD() throws SQLException{
    ArrayList<Derivados> ListaP = new ArrayList();
    String SQL = "SELECT * FROM derivados";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        while(rs.next()){
        Derivados der = new Derivados();
        der.setCd(rs.getString("codigo"));
        der.setNombre(rs.getString("nombre"));
        der.setCderivado(rs.getString("cderivado"));
        der.setNderivado(rs.getString("nderivado"));
        der.setDetalled(rs.getString("detalle"));
        der.setPrecio(rs.getFloat("precio"));
        ListaP.add(der);
        }
    }
    catch(SQLException e){
        System.out.println(""+e.getMessage());
    }
        finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }    
    }
    return ListaP;
    }
    
}
