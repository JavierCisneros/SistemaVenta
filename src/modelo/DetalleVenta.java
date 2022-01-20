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
public class DetalleVenta {
    private String cdproducto;
    private String nombre;
    private float cantidad;
    private float precio;
    private float subtotal;
    private int cdventa;

    public DetalleVenta() {
    }

    public DetalleVenta(String cdproducto,String nombre, float cantidad, float precio, float subtotal, int cdventa) {
        this.cdproducto = cdproducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.cdventa = cdventa;
    }

    public String getCdproducto() {
        return cdproducto;
    }

    public void setCdproducto(String cdproducto) {
        this.cdproducto = cdproducto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getCdventa() {
        return cdventa;
    }

    public void setCdventa(int cdventa) {
        this.cdventa = cdventa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
