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
public class Venta {
    private float total;
    private String vendedor;
    private String fecha;
    private int cdventa;

    public Venta(float total, String vendedor, String fecha, int cdventa) {
        this.total = total;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.cdventa = cdventa;
    }
    public Venta() {
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCdventa() {
        return cdventa;
    }

    public void setCdventa(int cdventa) {
        this.cdventa = cdventa;
    }
    
}
