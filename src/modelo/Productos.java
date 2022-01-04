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
    private int cd;
    private String name;
    private String detalle;
    private int udm;
    private float precio;
    private float base; 

    public Productos() {
    }

    public Productos(int cd, String name, String detalle, int udm, float precio, float base) {
        this.cd = cd;
        this.name = name;
        this.detalle = detalle;
        this.udm = udm;
        this.precio = precio;
        this.base = base;
    }
    

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
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
            
    
}
