/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mario Felipe
 */
public class Proyecto {

    private int id;
    private String nombreClave;
    private String denomComercial;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private String estado;
    private String codigoProyecto;
    private Promotor promotor;
    private List<Tarea> tareas;
    
    public Proyecto(){}

    public Proyecto(String nombreClave, String denomComercial, Date fechaInicio, Date fechaFinalizacion, String estado, String codigoProyecto, Promotor promotor, Tarea tareas) {
        
        this.nombreClave = nombreClave;
        this.denomComercial = denomComercial;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
        this.codigoProyecto = codigoProyecto;
        this.promotor = promotor;
        this.tareas = new ArrayList<Tarea>();        
          
    }

    public int getId() {
        return id;
    }    

    public String getNombreClave() {
        return nombreClave;
    }
    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public String getDenomComercial() {
        return denomComercial;
    }
    public void setDenomComercial(String denomComercial) {
        this.denomComercial = denomComercial;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }
    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }    

    public Promotor getPromotor() {
        return promotor;
    }
    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public List<Tarea> getTareas() {
        return this.tareas;
    }

    @Override
    public String toString() {
        return "Información del Proyecto." + "\n Nombre Clave: " + nombreClave + "\n Denominación Comercial: " + denomComercial + "\n Fecha de Inicio: " + fechaInicio + "\n Fecha de Finalización: " + fechaFinalizacion + "\n Estado: " + estado + "\n CodigoProyecto: " + codigoProyecto;
    }
    
     
}
