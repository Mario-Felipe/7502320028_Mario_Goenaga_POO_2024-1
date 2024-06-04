package Dominio;


import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Empresa")
public class Empresa implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String nit;
    private String nombre;
    private String telefono;
    private String correoElectronico;
    
    @OneToMany(mappedBy = "empresa")
    private LinkedList<Empleado> empleados;

    public Empresa() {
    }

    public Empresa(String nit, String nombre, String telefono, String correoElectronico, Empleado empleados) {

        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.empleados = new LinkedList<>();

    }

    public int getId() {
        return id;
    }
    
    

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LinkedList<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }
    

    @Override
    public String toString() {
        return "Datos de la Empresa. " + "\n Nit: " + nit + "\n Nombre: " + nombre + "\n Telefono: " + telefono + "\n Correo Electronico: " + correoElectronico;
    }
    
    
    

}
