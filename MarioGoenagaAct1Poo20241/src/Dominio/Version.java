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
    private String identificacion;
    private Date fecha;
    private String descripcion;
    private String empleado;
    private Documento documento;
    
    public Version(){}

    public Version(String identificacion, Date fecha, String descripcion, String empleado, Documento documento) {
        this.identificacion = identificacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.empleado = empleado;
        this.documento = documento;
    }
    
    public int getId() {
        return id;
    } 

    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Version de Documento." + "\n Fecha: " + fecha + "\n Descripcion: " + descripcion + "\n Empleado: " + empleado;
    }
    
    

}
