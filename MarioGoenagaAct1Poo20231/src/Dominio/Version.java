/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author Mario Felipe
 */
public class Version {

    private int id;
    private Date fecha;
    private String descripcion;
    private String empleado;
    private Documento documento;
    
    public Version(){}

    public Version(Date fecha, String descripcion, String empleado, Documento documento) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.empleado = empleado;
        this.documento = documento;
    }
    
    public int getId() {
        return id;
    }    

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpleado() {
        return empleado;
    }
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Documento getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return "Version de Documento." + "\n Fecha: " + fecha + "\n Descripcion: " + descripcion + "\n Empleado: " + empleado;
    }
    
    

}
