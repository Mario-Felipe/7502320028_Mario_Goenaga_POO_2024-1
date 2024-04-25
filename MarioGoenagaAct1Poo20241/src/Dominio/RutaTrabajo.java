/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Mario Felipe
 */
public class RutaTrabajo {

    private int id;
    private Empleado empleado;
    private Tarea tarea;
    
    public RutaTrabajo(){}

    public RutaTrabajo(Empleado empleado, Tarea tarea) {
        this.empleado = empleado;
        this.tarea = tarea;
    }
    
    public int getId() {
        return id;
    }    
   
    public Empleado getEmpleado() {
        return empleado;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    

}
