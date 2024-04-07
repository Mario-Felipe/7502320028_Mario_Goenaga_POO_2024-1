/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Mario Felipe
 */
public class Usuario {
    
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




