/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Mario Felipe
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Basic
    private String usuario;
    private String contrasena;
    private String estado;
    
    public Usuario(){}
    
    public Usuario(String usuario,String contrasena,String estado){
        
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
        
    
    } 
  
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }
     public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Datos del Usuario. " + "\n Usuario: " + usuario + "\n Contrasena: " + contrasena + "\n Estado: " + estado;
    }
     
    
}




