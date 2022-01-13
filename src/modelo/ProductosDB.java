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
    String SQL = "INSERT INTO `productos`(`cdproducto`, `name`, `detalle`, `udm`, `precio`, `base`, `stock`, `piezas`) VALUES (?,?,?,?,?,?,?,?)";
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
        pst.setFloat(7, pro.getStock());
        pst.setInt(8, pro.getPiezas());
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
    String SQL = "UPDATE `productos` SET `cdproducto`= ?,`name`= ?,`detalle`= ?,`udm`= ?,`precio`= ?,`base`= ?,`stock`= ?,`piezas`= ? WHERE `cdproducto`= ?";
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
        pst.setFloat(7, pro.getStock());
        pst.setInt(8, pro.getPiezas());
        pst.setInt(9, pro.getCd() );
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
        pd.setPiezas(rs.getInt("piezas"));
        ListaP.add(pd);
        }
    }
    catch(SQLException e){
        System.out.println(""+e.getMessage());
    }
    return ListaP;
    }
    public void ConsultarProductoG(JComboBox productos){
  String SQL = "SELECT name FROM productos WHERE udm = 1";
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
    public void ConsultarProductoU(JComboBox productos){
  String SQL = "SELECT name FROM productos WHERE udm = 2";
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
    public void ConsultarCodigosG(ArrayList<Integer> codigos){
  String SQL = "SELECT cdproducto FROM productos WHERE udm = 1";
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
    public void ConsultarCodigosU(ArrayList<Integer> codigos){
  String SQL = "SELECT cdproducto FROM productos WHERE udm = 2";
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
    public Productos BuscarPro(int pro){
    Productos producto = new Productos();
    String SQL = "SELECT * FROM productos WHERE cdproducto = ?";
            try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, pro);
        rs = pst.executeQuery();
                if (rs.next()) {
                    producto.setCd(rs.getInt("cdproducto"));
                    producto.setName(rs.getString("name"));
                    producto.setDetalle(rs.getString("detalle"));
                    producto.setUdm(rs.getInt("udm"));
                    producto.setPrecio(rs.getFloat("precio"));
                    producto.setBase(rs.getFloat("base"));
                    producto.setStock(rs.getFloat("stock"));
                    producto.setPiezas(rs.getInt("piezas"));
                }
            }catch(SQLException ex){
                System.out.println("no esta"+ex.toString());
            }    finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println("no esta 2"+e.toString());
    }    
    }
            
            return producto;
    }
    public Unidades BuscarUni(int pro){
    Unidades unidad = new Unidades();
    String SQL = "SELECT * FROM unidades WHERE cunidad = ?";
            try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, pro);
        rs = pst.executeQuery();
                if (rs.next()) {
                    unidad.setCodigo(rs.getInt("codigo"));
                    unidad.setNombre(rs.getString("nombre"));
                    unidad.setCdunidad(rs.getInt("cunidad"));
                    unidad.setNunidad(rs.getString("nunidad"));
                    unidad.setDetalleu(rs.getString("detalleu"));
                    unidad.setPiezas(rs.getInt("piezasu"));
                    unidad.setPreciou(rs.getFloat("preciou"));
                }
            }catch(SQLException ex){
                System.out.println(""+ex.toString());
            }    finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }    
    }
            
            return unidad;
    }
    public Derivados BuscarDer(int pro){
    Derivados derivado = new Derivados();
    String SQL = "SELECT * FROM derivados WHERE cderivado= ?";
            try{
        conexion = new Conexion();
        con = conexion.getConnection();
        pst = con.prepareStatement(SQL);
        pst.setInt(1, pro);
        rs = pst.executeQuery();
                if (rs.next()) {
                    derivado.setCd(rs.getInt("codigo"));
                    derivado.setNombre(rs.getString("nombre"));
                    derivado.setCderivado(rs.getInt("cderivado"));
                    derivado.setNderivado(rs.getString("nderivado"));
                    derivado.setDetalled(rs.getString("detalle"));
                    derivado.setPrecio(rs.getFloat("precio"));
                }
            }catch(SQLException ex){
                System.out.println(""+ex.toString());
            }    finally{
    try{
        con.close();
    }
    catch(SQLException e){
        System.out.println(""+e.toString());
    }    
    }
            
            return derivado;
    }
    
}
