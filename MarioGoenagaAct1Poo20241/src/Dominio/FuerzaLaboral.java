/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Mario Felipe
 */
public class FuerzaLaboral {

    private int id;
    private Empleado empleado;
    private Proyecto proyecto;
    
    public FuerzaLaboral(){}

    public FuerzaLaboral(Empleado empleado, Proyecto proyecto) {
        this.empleado = empleado;
        this.proyecto = proyecto;
    }
    
    public int getId() {
        return id;
    }    

    public Empleado getEmpleado() {
        return empleado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    

}
