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
public class Unidades {
    private String codigo;
    private String nombre;
    private String cdunidad;
    private String nunidad;
    private String detalleu;
    private int piezas;
    private float preciou;

    public Unidades() {
    }

    public Unidades(String codigo, String nombre, String cdunidad, String nunidad, String detalleu, int piezas, float preciou) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cdunidad = cdunidad;
        this.nunidad = nunidad;
        this.detalleu = detalleu;
        this.piezas = piezas;
        this.preciou = preciou;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCdunidad() {
        return cdunidad;
    }

    public void setCdunidad(String cdunidad) {
        this.cdunidad = cdunidad;
    }

    public String getNunidad() {
        return nunidad;
    }

    public void setNunidad(String nunidad) {
        this.nunidad = nunidad;
    }

    public String getDetalleu() {
        return detalleu;
    }

    public void setDetalleu(String detalleu) {
        this.detalleu = detalleu;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public float getPreciou() {
        return preciou;
    }

    public void setPreciou(float preciou) {
        this.preciou = preciou;
    }
    
     
}
