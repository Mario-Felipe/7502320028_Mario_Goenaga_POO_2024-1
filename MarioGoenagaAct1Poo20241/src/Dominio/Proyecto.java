package Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Producto")
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String nombreClave;
    private String denomComercial;    
    private String estado;
    private String codigoProyecto;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    private Date fechaFinalizacion;
    
    @ManyToOne
    private Promotor promotor;
    
    @OneToMany(mappedBy = "proyecto")
    private LinkedList<Tarea> tareas;
    
    public Proyecto(){}

    public Proyecto(String nombreClave, String denomComercial, Date fechaInicio, Date fechaFinalizacion, String estado, String codigoProyecto, Promotor promotor, Tarea tareas) {
        
        this.nombreClave = nombreClave;
        this.denomComercial = denomComercial;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado = estado;
        this.codigoProyecto = codigoProyecto;
        this.promotor = promotor;
        this.tareas = new LinkedList<>();       
          
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

    public LinkedList<Tarea> getTareas() {
        return this.tareas;
    }

    public void setTareas(LinkedList<Tarea> tareas) {
        this.tareas = tareas;
    }
    

    @Override
    public String toString() {
        return "Información del Proyecto." + "\n Nombre Clave: " + nombreClave + "\n Denominación Comercial: " + denomComercial + "\n Fecha de Inicio: " + fechaInicio + "\n Fecha de Finalización: " + fechaFinalizacion + "\n Estado: " + estado + "\n CodigoProyecto: " + codigoProyecto;
    }
    
     
}
