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
public class DetalleCompra {
    private int cdproducto;
    private float cantidad;
    private float precio;
    private float subtotal;
    private int cdcompra;

    public DetalleCompra() {
    }

    public DetalleCompra(int cdproducto, float cantidad, float precio,float subtotal, int cdcompra) {
        this.cdproducto = cdproducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cdcompra = cdcompra;
        this.subtotal = subtotal;
    }

    public int getCdproducto() {
        return cdproducto;
    }

    public void setCdproducto(int cdproducto) {
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

    public int getCdcompra() {
        return cdcompra;
    }

    public void setCdcompra(int cdcompra) {
        this.cdcompra = cdcompra;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
}
