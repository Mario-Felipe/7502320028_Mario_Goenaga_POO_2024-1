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


public class RutaTrabajo {

    private int id;
    
    private LinkedList<Empleado> empleado;
    
    private LinkedList<Tarea> tarea;
    
    //public RutaTrabajo(){}

    public RutaTrabajo() {
        this.empleado = new LinkedList<>();
        this.tarea = new LinkedList<>();
    }
    
//    public int getId() {
//        return id;
//    }    
//   
//    public Empleado getEmpleado() {
//        return empleado;
//    }
//
//    public Tarea getTarea() {
//        return tarea;
//    }
//
//    public void setEmpleado(Empleado empleado) {
//        this.empleado = empleado;
//    }
//
//    public void setTarea(Tarea tarea) {
//        this.tarea = tarea;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(LinkedList<Empleado> empleado) {
        this.empleado = empleado;
    }

    public LinkedList<Tarea> getTarea() {
        return tarea;
    }

    public void setTarea(LinkedList<Tarea> tarea) {
        this.tarea = tarea;
    }
    
    
    

}
