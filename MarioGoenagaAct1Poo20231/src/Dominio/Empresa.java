/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Felipe
 */
public class Empresa {

    private int id;
    private String nit;
    private String nombre;
    private String telefono;
    private String correoElectronico;
    private List<Empleado> empleados;

    public Empresa() {
    }

    public Empresa(String nit, String nombre, String telefono, String correoElectronico, Empleado empleados) {

        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.empleados = new ArrayList<Empleado>();

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

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    @Override
    public String toString() {
        return "Datos de la Empresa. " + "\n Nit: " + nit + "\n Nombre: " + nombre + "\n Telefono: " + telefono + "\n Correo Electronico: " + correoElectronico;
    }
    
    
    

}
