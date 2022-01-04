/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yopri
 */
public class Conexion {
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
