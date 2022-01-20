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
public class UnidadesDB {
    Conexion conexion;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public boolean agregarU(Unidades un){
    String SQL = "INSERT INTO `unidades`(`codigo`, `nombre`, `cunidad`, `nunidad`, `detalleu`, `piezasu`, `preciou`) VALUES  (?,?,?,?,?,?,?)";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, un.getCodigo());
        pst.setString(2, un.getNombre());
        pst.setString(3, un.getCdunidad());
        pst.setString(4, un.getNunidad());
        pst.setString(5, un.getDetalleu());
        pst.setInt(6, un.getPiezas());
        pst.setFloat(7, un.getPreciou());
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
    public boolean eliminarU(String id){
    String SQL = "DELETE FROM unidades WHERE cunidad = ?";
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
    public boolean editarU(Unidades un){
    String SQL = "UPDATE `unidades` SET `codigo`=?,`nombre`=?,`cunidad`=?,`nunidad`= ?,`detalleu`=?,`piezasu`= ?,`preciou`= ? WHERE `cunidad` = ?";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setString(1, un.getCodigo());
        pst.setString(2, un.getNombre());
        pst.setString(3, un.getCdunidad());
        pst.setString(4, un.getNunidad());
        pst.setString(5, un.getDetalleu());
        pst.setInt(6, un.getPiezas());
        pst.setFloat(7, un.getPreciou());
        pst.setString(8, un.getCdunidad());
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
    public ArrayList ListarProductosU() throws SQLException{
    ArrayList<Unidades> ListaP = new ArrayList();
    String SQL = "SELECT * FROM unidades";
    try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        rs = pst.executeQuery();
        while(rs.next()){
        Unidades uni = new Unidades();
        uni.setCodigo(rs.getString("codigo"));
        uni.setNombre(rs.getString("nombre"));
        uni.setCdunidad(rs.getString("cunidad"));
        uni.setNunidad(rs.getString("nunidad"));
        uni.setDetalleu(rs.getString("detalleu"));
        uni.setPiezas(rs.getInt("piezasu"));
        uni.setPreciou(rs.getFloat("preciou"));
        ListaP.add(uni);
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
