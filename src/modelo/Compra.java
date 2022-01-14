/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author yopri
 */
public class Compra {
    private float total;
    private String Vendedor;
    private String fecha;
    private int Cdcompra;
    public Compra() {
    }

    public Compra(float total, String Vendedor, String fecha, int Cdcompra) {
        this.total = total;
        this.Vendedor = Vendedor;
        this.fecha = fecha;
        this.Cdcompra = Cdcompra;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCdcompra() {
        return Cdcompra;
    }

    public void setCdcompra(int Cdcompra) {
        this.Cdcompra = Cdcompra;
    }
    
    
}
