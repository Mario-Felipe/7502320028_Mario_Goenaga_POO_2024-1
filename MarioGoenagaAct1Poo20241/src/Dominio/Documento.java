package Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Documento")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Basic
    private String proyecto;
    private String codigoDocumento;    
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaDocumento;
    
    @ManyToOne
    private Tarea tarea;
    @OneToMany(mappedBy = "documento")
    private LinkedList<Version> versiones;
    
    public Documento(){}

    public Documento(String proyecto, String codigoDocumento, Date fechaDocumento, String descripcion, Tarea tarea, Version versiones) {
        
        this.proyecto = proyecto;
        this.codigoDocumento = codigoDocumento;
        this.fechaDocumento = fechaDocumento;
        this.descripcion = descripcion;
        this.tarea = tarea;
        this.versiones = new LinkedList<>();
                
    }
    
    public int getId() {
        return id;
    }  
    public void setId(int id) {
        this.id = id;
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

    public LinkedList<Version> getVersiones() {
        return this.versiones;
    }

    public void setVersiones(LinkedList<Version> versiones) {
        this.versiones = versiones;
    }
    
    public void agregarVersion(Version version){
        this.versiones.add(version);
    }
    
    public void quitarVersion(Version version){
        this.versiones.remove(version);
    }

        

    @Override
    public String toString() {
        return "Documento Generado." + "\n Proyecto: " + proyecto + "\n Codigo de Documento: " + codigoDocumento + "\n Fecha de Documento: " + fechaDocumento + "\n descripcion: " + descripcion;
    }
    
      public Vector<String> convertirAVector(){
        Vector<String> datos = new Vector<String>();
        datos.addElement(proyecto);
        datos.addElement(codigoDocumento);
        return datos;
   }

    }
