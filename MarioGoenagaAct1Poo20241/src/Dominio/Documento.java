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
public class Documento {

    private int id;
    private String proyecto;
    private String codigoDocumento;
    private Date fechaDocumento;
    private String descripcion;
    private Tarea tarea;
    private List<Version> versiones;
    
    public Documento(){}

    public Documento(String proyecto, String codigoDocumento, Date fechaDocumento, String descripcion, Tarea tarea, Version versiones) {
        
        this.proyecto = proyecto;
        this.codigoDocumento = codigoDocumento;
        this.fechaDocumento = fechaDocumento;
        this.descripcion = descripcion;
        this.tarea = tarea;
        this.versiones = new ArrayList<Version>();
                
    }
    
    public int getId() {
        return id;
    }    

    public String getProyecto() {
        return proyecto;
    }
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }
    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }
    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tarea getTarea() {
        return tarea;
    }
    

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public List<Version> getVersiones() {
        return this.versiones;
    }

    @Override
    public String toString() {
        return "Documento Generado." + "\n Proyecto: " + proyecto + "\n Codigo de Documento: " + codigoDocumento + "\n Fecha de Documento: " + fechaDocumento + "\n descripcion: " + descripcion;
    }

    
    

    

    

    
    
    

}
