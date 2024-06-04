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

@Entity(name = "Tarea")
public class Tarea implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String identificadorTarea;
    private String descripcion;
    private String tipo;    
    private String duracionEstimada;
    private String duracionReal;
    private String empleado;
    private String prioridad;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicioEstimada;
    private Date fechaInicioReal;
    
    @ManyToOne
    private Proyecto proyecto;
    
    @OneToMany(mappedBy = "tarea")
    private LinkedList<Documento> documentos;
    
    public Tarea() {
    }

    public Tarea(String identificadorTarea, String descripcion, String tipo, Date fechaInicioEstimada, Date fechaInicioReal, String duracionEstimada, String duracionReal, String empleado, String prioridad, Proyecto proyecto, Documento documentos) {

        this.identificadorTarea = identificadorTarea;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicioEstimada = fechaInicioEstimada;
        this.fechaInicioReal = fechaInicioReal;
        this.duracionEstimada = duracionEstimada;
        this.duracionReal = duracionReal;
        this.empleado = empleado;
        this.prioridad = prioridad;
        this.proyecto = proyecto;
        this.documentos = new LinkedList<>();

    }
    
    public int getId() {
        return id;
    }    
    
    public String getIdentificadorTarea() {
        return identificadorTarea;
    }
    public void setIdentificadorTarea(String identificadorTarea) {
        this.identificadorTarea = identificadorTarea;
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

    public LinkedList<Documento> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(LinkedList<Documento> documentos) {
        this.documentos = documentos;
    }
    

    @Override
    public String toString() {
        return "Registo de Tarea." + "\n Identificador: " + identificadorTarea + "\n Descripcion: " + descripcion + "\n Tipo: " + tipo + "\n Fecha de Inicio de Estimada: " + fechaInicioEstimada + "\n Fecha de Inicio Real: " + fechaInicioReal + "\n Duración Estimada: " + duracionEstimada + "\n DuracionReal: " + duracionReal + "\n Empleado: " + empleado + "\n Prioridad: " + prioridad;
    }
    
    

    

    

    

    

    

    

    

    
    

}
