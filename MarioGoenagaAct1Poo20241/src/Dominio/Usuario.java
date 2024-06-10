/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.Vector;
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

@Entity(name = "Usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
     
    /*Metodo para devolver un arreglo o vector con los datos de Usduario
     *con el fin de que dicho arreglo o vector sea parte de las filas de un JTable
     */
    
    public Vector<String> convertirAVector(){
        Vector<String> datos = new Vector<String>();
        datos.addElement(usuario);
        datos.addElement(estado);
        return datos;
   }
    
}




