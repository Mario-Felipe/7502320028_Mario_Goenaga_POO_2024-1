/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.LinkedList;

/**
 *
 * @author Mario Felipe
 */

public class FuerzaLaboral {
    
    
    private int id;    
    
    private LinkedList <Empleado> empleado;
   
    private LinkedList <Proyecto> proyecto;
    
    //public FuerzaLaboral(){}

    public FuerzaLaboral() {
        this.empleado = new LinkedList<>();
        this.proyecto = new LinkedList<>();
    }
    
    public int getId() {
        return id;
    }       

//    public Empleado getEmpleado() {
//        return empleado;
//    }
//
//    public Proyecto getProyecto() {
//        return proyecto;
//    }
//
//    public void setEmpleado(Empleado empleado) {
//        this.empleado = empleado;
//    }
//
//    public void setProyecto(Proyecto proyecto) {
//        this.proyecto = proyecto;
//    }

    public LinkedList<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(LinkedList<Empleado> empleado) {
        this.empleado = empleado;
    }

    public LinkedList<Proyecto> getProyecto() {
        return proyecto;
    }

    public void setProyecto(LinkedList<Proyecto> proyecto) {
        this.proyecto = proyecto;
    }
    
    

}
