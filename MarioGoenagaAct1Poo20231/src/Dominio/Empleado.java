/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Date;
/**
 *
 * @author Mario Felipe
 */
public class Empleado extends Usuario{

    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Date fechaContratacion;
    private String rol;
    private String tipoContrato;
    private Date fechaNacimiento;
    private Empresa empresa;
    
    public Empleado() {}

    public Empleado(String usuario,String contrasena,String estado,String dni, String nombre, String apellido, String direccion, String telefono, String correoElectronico, Date fechaContratacion, String rol, String tipoContrato, Date fechaNacimiento, Empresa empresa) {
        
        super(usuario, contrasena, estado);
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaContratacion = fechaContratacion;
        this.rol = rol;
        this.tipoContrato = tipoContrato;
        this.fechaNacimiento = fechaNacimiento;
        this.empresa = empresa;
        
    }
    
    public String getDni() {
        return dni;
    }    
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }
     public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Date getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getRol() {
        return rol;
    }
     public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Ficha del Empleado: " + "\n DNI: " + dni + "\n Nombre: " + nombre + "\n Apellido: " + apellido + "\n Direccion: " + direccion + "\n Telefono: " + telefono + "\n Correo Electronico: " + correoElectronico + "\n Fecha de Contratacion: " + fechaContratacion + "\n Rol: " + rol + "\n Tipo de Contrato: " + tipoContrato;
    }

    

    
    

}
