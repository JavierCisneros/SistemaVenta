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
public class Derivados {
    private int cd;
    private String nombre;
    private int cderivado;
    private String nderivado;
    private String detalled;
    private float precio;


    public Derivados() {
    }

    public Derivados(int cd, String nombre, int cderivado, String nderivado, String detalled, float precio) {
        this.cd = cd;
        this.nombre = nombre;
        this.cderivado = cderivado;
        this.nderivado = nderivado;
        this.detalled = detalled;
        this.precio = precio;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCderivado() {
        return cderivado;
    }

    public void setCderivado(int cderivado) {
        this.cderivado = cderivado;
    }

    public String getNderivado() {
        return nderivado;
    }

    public void setNderivado(String nderivado) {
        this.nderivado = nderivado;
    }

    public String getDetalled() {
        return detalled;
    }

    public void setDetalled(String detalled) {
        this.detalled = detalled;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
   
    
}
