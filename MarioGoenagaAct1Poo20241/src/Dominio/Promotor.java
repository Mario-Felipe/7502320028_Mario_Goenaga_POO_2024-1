package Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "Promotor")
public class Promotor extends Empleado implements Serializable {
    @Basic
    private String area;
     
    @OneToMany(mappedBy = "promotor")
    private LinkedList<Proyecto> proyectos;

    public Promotor() {
    }

    public Promotor(String usuario, String contrasena, String estado, String dni, String nombre, String apellido, String direccion, String telefono, String correoElectronico, Date fechaContratacion, String rol, String tipoContrato, Empresa empresa, String area, Proyecto proyectos, Date fechaNacimiento) {

        super(usuario, contrasena, estado, dni, nombre, apellido, direccion, telefono, correoElectronico, fechaContratacion, rol, tipoContrato, fechaNacimiento, empresa);
        this.proyectos = new LinkedList<>();

    }
    
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    
    
    public LinkedList<Proyecto> getProyectos() {
        return this.proyectos;
    }

    @Override
    public String toString() {
        return "Conocimiento relacionado de Promotor. " + "Área de Trabajo: " + area;
    }
    
    

}
