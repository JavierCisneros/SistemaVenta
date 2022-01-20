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
public class Productos {
    private String cd;
    private String name;
    private String detalle;
    private int udm;
    private float precio;
    private float base; 
    private float stock;
    private int piezas;

    public Productos() {
    }

    public Productos(String cd, String name, String detalle, int udm, float precio, float base, float stock, int piezas) {
        this.cd = cd;
        this.name = name;
        this.detalle = detalle;
        this.udm = udm;
        this.precio = precio;
        this.base = base;
        this.stock = stock;
        this.piezas = piezas;
    }
    

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getUdm() {
        return udm;
    }

    public void setUdm(int udm) {
        this.udm = udm;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }
            
    
}
