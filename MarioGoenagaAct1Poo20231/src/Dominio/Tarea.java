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
public class Tarea {

    private int id;
    private String descripcion;
    private String tipo;
    private Date fechaInicioEstimada;
    private Date fechaInicioReal;
    private String duracionEstimada;
    private String duracionReal;
    private String empleado;
    private String prioridad;
    private Proyecto proyecto;
    private List<Documento> documentos;

    public Tarea() {
    }

    public Tarea(String descripcion, String tipo, Date fechaInicioEstimada, Date fechaInicioReal, String duracionEstimada, String duracionReal, String empleado, String prioridad, Proyecto proyecto, Documento documentos) {

        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicioEstimada = fechaInicioEstimada;
        this.fechaInicioReal = fechaInicioReal;
        this.duracionEstimada = duracionEstimada;
        this.duracionReal = duracionReal;
        this.empleado = empleado;
        this.prioridad = prioridad;
        this.proyecto = proyecto;
        this.documentos = new ArrayList<Documento>();

    }
    
    public int getId() {
        return id;
    }    

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicioEstimada() {
        return fechaInicioEstimada;
    }
    public void setFechaInicioEstimada(Date fechaInicioEstimada) {
        this.fechaInicioEstimada = fechaInicioEstimada;
    }

    public Date getFechaInicioReal() {
        return fechaInicioReal;
    }
    public void setFechaInicioReal(Date fechaInicioReal) {
        this.fechaInicioReal = fechaInicioReal;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }
    public void setDuracionEstimada(String duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getDuracionReal() {
        return duracionReal;
    }
    public void setDuracionReal(String duracionReal) {
        this.duracionReal = duracionReal;
    }

    public String getEmpleado() {
        return empleado;
    }
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Documento> getDocumentos() {
        return this.documentos;
    }

    @Override
    public String toString() {
        return "Registo de Tarea." + "\n Descripcion: " + descripcion + "\n Tipo: " + tipo + "\n Fecha de Inicio de Estimada: " + fechaInicioEstimada + "\n Fecha de Inicio Real: " + fechaInicioReal + "\n Duración Estimada: " + duracionEstimada + "\n DuracionReal: " + duracionReal + "\n Empleado: " + empleado + "\n Prioridad: " + prioridad;
    }
    
    

    

    

    

    

    

    

    

    
    

}
