/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Versiones")
public class Version implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String identificacion;    
    private String descripcion;
    private String empleado;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
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
