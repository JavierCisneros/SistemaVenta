/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author yopri
 */
public class database {
    public static int rol; //Rol del usuario
    public static String name; //Nombre del usuario
    public static class Conexion{
    private String servidor="jdbc:mysql://localhost/sistemaventa";
    private String user="root";
    private String pass="";
    private String driver="com.mysql.jdbc.Driver";
    private Connection conexion;
    public Conexion() throws SQLException{
    try{
    Class.forName(driver);
    conexion=(Connection) DriverManager.getConnection(servidor,user,pass);
    }
    catch(ClassNotFoundException | SQLException e){
        
    }}
        public Connection getConnection(){
    
    return conexion;
        }
    }   
    
    public static int validarUsuario(String password, String Usuario) throws SQLException{
    Conexion conexion = new Conexion();
    Connection con=conexion.getConnection();
    int resultado=0;
    String pass=password;
    String user=Usuario;
    String SQL="select * from usuarios where name='"+user+"' and password='"+pass+"'";
    try{
    Statement st = con.createStatement();
    ResultSet rs= st.executeQuery(SQL);
        if (rs.next()) {
            resultado = 1;
            name=rs.getString(2);
            rol=rs.getInt(4);
        }
    }
    catch(SQLException ex){
        System.out.println("Login fail"+ex.getMessage());   
    }
    return resultado;
    }
    
    public static int agregarUsuario(String usuario, String password, int rol) throws SQLException{
    Conexion conexion = new Conexion();
    Connection con=conexion.getConnection();
    int resultado = 0;
    String SQL = "INSERT INTO `usuarios`(`name`, `password`, `rol`) VALUES (?,?,?)";
     PreparedStatement pst=null;
    try{
    pst = con.prepareStatement(SQL);
    pst.setString(1, usuario);
    pst.setString(2, password);
    pst.setInt(3, rol);
    pst.executeUpdate();
    }
    catch(SQLException ex){
        resultado = 1;
        System.out.println("Error al agregar"+ ex.getMessage());
    }
    return resultado;
    }
}

